package com.example.EmployeeShift.dao.clock_date;

import com.example.EmployeeShift.entity.clock_date.ClockDate;
import com.example.EmployeeShift.entity.clock_date.ClockDateId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClockDateDao extends JpaRepository<ClockDate, ClockDateId> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clock_date (branch_id,employee_id,clock_on) VALUES " +
            "(?1,?2,?3)",nativeQuery = true)
    public void addClockDate(int branch_id, String employee_id, LocalDateTime clock_on);

    @Modifying
    @Transactional
    @Query(value = "UPDATE clock_date SET " +
            "clock_on = CASE WHEN :clock_on IS NULL THEN clock_on ELSE :clock_on END, "+
            "clock_off = CASE WHEN :clock_off IS NULL THEN clock_off ELSE :clock_off END, " +
            "total_hours = CASE WHEN :total_hours IS NULL THEN total_hours ELSE :total_hours END, "+
            "`check` = CASE WHEN :check IS NULL THEN `check` ELSE :check END, "+
            "score = CASE WHEN :score IS NULL THEN score ELSE :score END "+
            "WHERE branch_id = ?1 AND employee_id = ?2",nativeQuery = true)
    public void updateClockDate(int branch_id, String employee_id, LocalDateTime clock_on,LocalDateTime clock_off,
                                double total_hours,boolean check,int score);

    @Modifying
    @Transactional
    @Query(value = "UPDATE clock_date SET " +
            "clock_off = CASE WHEN :clock_off IS NULL THEN clock_off ELSE :clock_off END, " +
            "total_hours = CASE WHEN :total_hours IS NULL THEN total_hours ELSE :total_hours END, "+
            "`check` = CASE WHEN :check IS NULL THEN `check` ELSE :check END, "+
            "score = CASE WHEN :score IS NULL THEN score ELSE :score END "+
            "WHERE branch_id = ?1 AND employee_id = ?2",nativeQuery = true)
    public void updateClockDate(int branch_id, String employee_id,LocalDateTime clock_off,
                                double total_hours,boolean check,int score);

    @Query(value = "SELECT * FROM clock_date WHERE branch_id = ?1 AND employee_id = ?2",nativeQuery = true)
    public ClockDate getClockDateById(int branch_id,String employee_id);

    @Query(value = "SELECT * FROM clock_date WHERE branch_id = ?1",nativeQuery = true)
    public List<ClockDate> getAllClockDate(int branch_id);
}
