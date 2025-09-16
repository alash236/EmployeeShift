package com.example.EmployeeShift.dao.notify;

import com.example.EmployeeShift.entity.notify.Notify;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NotifyDao extends JpaRepository<Notify,Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO notify (branch_id,id,text,notify_start_time,notify_end_time) VALUES " +
            "(:branch_id,:notify_id,:notify_text,:notify_startTime,:notify_endTime)",nativeQuery = true)
    public void addNotify(int branch_id,int notify_id,String notify_text, LocalDate notify_startTime,LocalDate notify_endTime);

    @Modifying
    @Transactional
    @Query(value = "UPDATE notify SET " +
            "text = CASE WHEN :notify_text is NULL OR :notify_text = '' THEN text ELSE :notify_text END, " +
            "notify_start_time = CASE WHEN :notify_startTime is NULL OR :notify_startTime = '' THEN notify_start_time ELSE :notify_startTime END, " +
            "notify_end_time = CASE WHEN :notify_endTime is NULL OR :notify_endTime = '' THEN notify_end_time ELSE :notify_endTime END " +
            "WHERE id = :notify_id AND branch_id = :branch_id",nativeQuery = true)
    public void updateNotify(int branch_id,int notify_id,String notify_text,LocalDate notify_startTime,LocalDate notify_endTime);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM notify WHERE id = :notify_id AND branch_id = :branch_id",nativeQuery = true)
    public void deleteNotify(int branch_id,int notify_id);

    @Query(value ="SELECT * FROM notify WHERE id = :notify_id AND branch_id = :branch_id",nativeQuery = true)
    public Notify getNotifyById(int branch_id,int notify_id);

    @Query(value ="SELECT * FROM notify where branch_id = :branch_id" ,nativeQuery = true)
    public List<Notify> getAllNotify(int branch_id);
}
