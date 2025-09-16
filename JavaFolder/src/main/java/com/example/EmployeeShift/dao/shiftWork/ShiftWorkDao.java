package com.example.EmployeeShift.dao.shiftWork;

import com.example.EmployeeShift.entity.shiftWork.ShiftWork;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface ShiftWorkDao extends JpaRepository<ShiftWork,Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO shift_work " +
            "(shift_work_id,start_time,end_Time) VALUES " +
            "(:shift_work_id,:start_time,:end_Time)" ,nativeQuery = true)
    public void addShiftWork(int shift_work_id, LocalTime start_time,LocalTime end_Time);

    @Modifying
    @Transactional
    @Query(value = "UPDATE shift_work SET " +
            "start_time = CASE WHEN :start_time IS NULL OR :start_time = '' THEN start_time ELSE :start_time END, " +
            "end_time = CASE WHEN :end_time IS NULL OR :end_time = '' THEN end_time ELSE :end_time END " +
            "WHERE shift_work_id = :shift_work_id",nativeQuery = true)
    public void updateShiftWork(int shift_work_id, LocalTime start_time,LocalTime end_time);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM shift_work WHERE shift_work_id = :shift_work_id",nativeQuery = true)
    public void deleteShiftWork(int shift_work_id);

    @Query(value = "SELECT * FROM shift_work WHERE shift_work_id = :shift_work_id",nativeQuery = true)
    public ShiftWork getShiftWorkByShiftWorkId(int shift_work_id);

    @Query(value = "SELECT * FROM shift_work",nativeQuery = true)
    public List<ShiftWork>getAllShiftWork();

}
