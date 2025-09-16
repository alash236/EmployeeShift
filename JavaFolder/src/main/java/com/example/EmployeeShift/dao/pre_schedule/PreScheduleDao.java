package com.example.EmployeeShift.dao.pre_schedule;

import com.example.EmployeeShift.entity.pre_schedule.PreSchedule;
import com.example.EmployeeShift.entity.pre_schedule.PreScheduleId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PreScheduleDao extends JpaRepository<PreSchedule, PreScheduleId> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO pre_schedule " +
            "(branch_id,employee_id,apply_date,is_working,shift_work_id) VALUES " +
            "(:branch_id,:employee_id,:apply_date,:is_working,:shift_work_id)" ,nativeQuery = true)
    public void addPreSchedule(int branch_id, String employee_id, LocalDate apply_date,boolean is_working,int shift_work_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE pre_schedule SET " +
            "is_working = CASE WHEN :is_working IS NULL OR :is_working = '' THEN is_working ELSE :is_working END, " +
            "shift_work_id = CASE WHEN :shift_work_id is NULL OR :shift_work_id = '' THEN shift_work_id ELSE :shift_work_id END, " +
            "is_accept = CASE WHEN :is_accept is NULL OR :is_accept = '' THEN is_accept ELSE :is_accept END " +
            "WHERE branch_id = :branch_id AND employee_id = :employee_id AND apply_date = :apply_date", nativeQuery = true)
    public void updatePreSchedule(int branch_id, String employee_id, LocalDate apply_date,boolean is_working,int shift_work_id,boolean is_accept);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM pre_schedule WHERE branch_id = :branch_id AND employee_id = :employee_id",nativeQuery = true)
    public void deletePreSchedule(int branch_id, String employee_id);

    @Query(value = "SELECT * FROM pre_schedule where branch_id = :branch_id AND employee_id = :employee_id",nativeQuery = true)
    public PreSchedule getPreScheduleById(int branch_id,String employee_id);

    @Query(value = "SELECT * FROM pre_schedule where branch_id = :branch_id AND apply_date = :apply_date AND is_working = :is_working",nativeQuery = true)
    public List<PreSchedule> getAllPreSchedule(int branch_id,LocalDate apply_date,boolean is_working);

}
