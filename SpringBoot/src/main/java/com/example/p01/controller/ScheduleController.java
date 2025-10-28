package com.example.p01.controller;

import com.example.p01.dao.HeadDao;
import com.example.p01.dao.PreScheduleMyBatisDao;
import com.example.p01.entity.Employee;
import com.example.p01.entity.PreSchedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // 標註這個類是 REST API 控制器
public class ScheduleController {

    // 定義可排班別，假設有 4 個班別
    private static final List<Integer> SHIFTS = Arrays.asList(1, 2, 3, 4);

    private static final int HOURS_PER_SHIFT = 4; // 每個班別的工時
    private static final int MAX_HOURS_PER_WEEK = 40; // 每週最多工時
    private static final int MAX_SHIFTS_PER_DAY = 2; // 每天最多排 2 班

    @Autowired
    private HeadDao headDao; // 注入 DAO，用來取得員工資料

    @Autowired
    private PreScheduleMyBatisDao preScheduleMyBatisDao; // 注入 DAO，用來存取排班資料

    @GetMapping("/shift")
    public int generateAndSaveMonthScheduleRandom() {
        List<Employee> employees = headDao.findAll(); // 所有員工
        Map<String, Integer> hoursWorkedThisWeek = new HashMap<>(); // 每週工時紀錄
        Map<String, Integer> daysWorkedThisWeek = new HashMap<>(); // 每週上班天數紀錄
        Random random = new Random();

        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.plusMonths(1).withDayOfMonth(1);
        LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());

        // 取得這個月 + 上週的預排班資料（避免重複）
        List<PreSchedule> preSchedules = preScheduleMyBatisDao.findAllByApplyDateBetween(
                firstDayOfMonth.minusDays(7), lastDayOfMonth);

        // 整理成 Map（key = 員工ID, value = 該員工的排班清單）
        Map<String, List<PreSchedule>> preScheduleMap = new HashMap<>();
        preSchedules.forEach(ps ->
                preScheduleMap.computeIfAbsent(ps.getEmployeeId(), k -> new ArrayList<>()).add(ps)
        );

        // 初始化每個員工的工時與上班天數
        for (Employee emp : employees) {
            String empId = emp.getId();
            hoursWorkedThisWeek.put(empId, 0);
            List<PreSchedule> list = preScheduleMap.getOrDefault(empId, new ArrayList<>());
            int workedDays = (int) list.stream()
                    .filter(ps -> ps.getApplyDate().isBefore(firstDayOfMonth.plusDays(7))
                            && ps.getShiftWorkId() != 0)
                    .count();
            daysWorkedThisWeek.put(empId, workedDays);
        }

        //  每週的固定休假日配置表
        Map<String, Map<Integer, List<LocalDate>>> employeeRestDays = new HashMap<>();

        //  逐天排班
        for (int i = 0; i < lastDayOfMonth.lengthOfMonth(); i++) {
            LocalDate day = firstDayOfMonth.plusDays(i);

            // 每週週一重置週統計
            if (day.getDayOfWeek().getValue() == 1) {
                for (Employee emp : employees) {
                    hoursWorkedThisWeek.put(emp.getId(), 0);
                    daysWorkedThisWeek.put(emp.getId(), 0);
                }
            }

            // 這一天屬於第幾週（0起算）
            int weekOfMonth = (i / 7);
            LocalDate weekStart = firstDayOfMonth.plusDays(weekOfMonth * 7);
            LocalDate weekEnd = weekStart.plusDays(6);

            for (Employee emp : employees) {
                String empId = emp.getId();

                // 已有排班 → 跳過
                boolean hasPre = preScheduleMap.getOrDefault(empId, new ArrayList<>())
                        .stream().anyMatch(ps -> ps.getApplyDate().equals(day));
                if (hasPre) continue;

                // 如果還沒為該員工建立這週的休假日，就先隨機產生
                employeeRestDays.computeIfAbsent(empId, x -> new HashMap<>());
                Map<Integer, List<LocalDate>> restDaysByWeek = employeeRestDays.get(empId);

                if (!restDaysByWeek.containsKey(weekOfMonth)) {
                    List<LocalDate> restDays = new ArrayList<>();
                    random.setSeed(empId.hashCode() + weekOfMonth); // 同員工同週固定結果
                    while (restDays.size() < 2) { // 每週兩天休
                        int restOffset = random.nextInt(7);
                        LocalDate restDay = weekStart.plusDays(restOffset);
                        if (!restDay.isAfter(lastDayOfMonth) && !restDays.contains(restDay)) {
                            restDays.add(restDay);
                        }
                    }
                    restDaysByWeek.put(weekOfMonth, restDays);
                }

                List<LocalDate> restDays = restDaysByWeek.get(weekOfMonth);

                // 若這天是休假日
                if (restDays.contains(day)) {
                    PreSchedule ps = new PreSchedule(empId, day, 0, true);
                    preScheduleMyBatisDao.addSchdule(ps);
                    continue;
                }

                // 若超過每週工時上限
                if (hoursWorkedThisWeek.get(empId) >= MAX_HOURS_PER_WEEK) {
                    PreSchedule ps = new PreSchedule(empId, day, 0, true);
                    preScheduleMyBatisDao.addSchdule(ps);
                    continue;
                }

                //  隨機排 1~2 班（依剩餘工時）
                int maxPossibleShifts = Math.min(MAX_SHIFTS_PER_DAY,
                        (MAX_HOURS_PER_WEEK - hoursWorkedThisWeek.get(empId)) / HOURS_PER_SHIFT);
                if (maxPossibleShifts <= 0) {
                    PreSchedule ps = new PreSchedule(empId, day, 0, true);
                    preScheduleMyBatisDao.addSchdule(ps);
                    continue;
                }

                // 洗牌
                int shiftsToday = random.nextInt(maxPossibleShifts) + 1;
                List<Integer> shiftPool = new ArrayList<>(SHIFTS);
                Collections.shuffle(shiftPool);
                List<Integer> assignedShifts = shiftPool.subList(0, shiftsToday);

                // 寫入資料庫
                for (int shift : assignedShifts) {
                    PreSchedule ps = new PreSchedule(empId, day, shift, true);
                    preScheduleMyBatisDao.addSchdule(ps);
                }

                // 更新工時與天數
                hoursWorkedThisWeek.put(empId,
                        hoursWorkedThisWeek.get(empId) + shiftsToday * HOURS_PER_SHIFT);
                daysWorkedThisWeek.put(empId,
                        daysWorkedThisWeek.get(empId) + 1);
            }
        }

        return 200;
    }
}
