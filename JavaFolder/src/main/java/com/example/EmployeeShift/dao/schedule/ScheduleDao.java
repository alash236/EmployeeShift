package com.example.EmployeeShift.dao.schedule;

import com.example.EmployeeShift.dto.ScheduleDto;
import com.example.EmployeeShift.dto.ShiftDto;
import com.example.EmployeeShift.entity.schedule.Schedule;
import com.example.EmployeeShift.entity.schedule.ScheduleId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleDao extends JpaRepository<Schedule, ScheduleId> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO schedule " +
            "(branch_id,employee_id,shift_work_id,work_date) VALUES " +
            "(:branch_id,:employee_id,:shift_work_id,:work_date)",nativeQuery = true)
    public void addSchedule(int branch_id, String employee_id, int shift_work_id, LocalDate work_date);

    @Modifying
    @Transactional
    @Query(value = "UPDATE schedule SET " +
            "shift_work_id = CASE WHEN :shift_work_id = NULL OR :shift_work_id = '' THEN shift_work_id ELSE :shift_work_id END, " +
            "work_date = CASE WHEN :work_date = NULL OR :work_date = '' THEN work_date ELSE :work_date END " +
            "WHERE branch_id = :branch_id AND employee_id = :employee_id",nativeQuery = true)
    public void updateSchedule(int branch_id, String employee_id, int shift_work_id, LocalDate work_date);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM schedule WHERE branch_id = :branch_id AND employee_id = :employee_id",nativeQuery = true)
    public void deleteSchedule(int branch_id, String employee_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM schedule WHERE branch_id = :branch_id",nativeQuery = true)
    public void deleteSchedule(int branch_id);

    @Query(value = "SELECT * FROM schedule WHERE branch_id = :branch_id AND employee_id = :employee_id",nativeQuery = true)
    public Schedule getScheduleById(int branch_id,String employee_id);

    @Query("SELECT new com.example.EmployeeShift.dto.ShiftDto(be.branch_employee_id,be.branch_employee_name, s.work_date, sw.start_time, sw.end_time) " +
            "FROM Schedule s " +
            "JOIN BranchEmployee be ON s.branch_id = be.branch_id AND s.employee_id = be.branch_employee_id " +
            "JOIN ShiftWork sw ON s.shift_work_id = sw.shift_work_id " +
            "WHERE s.branch_id = :branch_id")
    public List<ShiftDto> getAllShift(int branch_id);

    @Query("SELECT new com.example.EmployeeShift.dto.ScheduleDto( " +
            "ps.branch_id, ps.employee_id, sw.shift_work_id, be.branch_employee_state, ps.apply_date, ps.is_working, ps.is_accept ) " +
            "FROM PreSchedule ps " +
            "JOIN BranchEmployee be ON ps.branch_id = be.branch_id AND ps.employee_id = be.branch_employee_id " +
            "JOIN ShiftWork sw ON ps.shift_work_id = sw.shift_work_id " +
            "WHERE ps.branch_id = :branch_id")
    public List<ScheduleDto> getAllSchedule(int branch_id);


}
