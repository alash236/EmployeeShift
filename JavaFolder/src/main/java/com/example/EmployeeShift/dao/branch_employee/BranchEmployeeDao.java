package com.example.EmployeeShift.dao.branch_employee;

import com.example.EmployeeShift.entity.branch_employee.BranchEmployee;
import com.example.EmployeeShift.entity.branch_employee.BranchEmployeeId;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchEmployeeDao extends JpaRepository<BranchEmployee, BranchEmployeeId> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO branch_employee " +
            "(branch_id,id,name,status,email,phone,title) VALUES " +
            "(:branch_id,:branch_employee_id,:branch_employee_name,:branch_employee_state,:branch_employee_email,:branch_employee_phone,:branch_employee_title)",nativeQuery = true)
    public void addBranchEmployee(int branch_id,String branch_employee_id,String branch_employee_name,String branch_employee_state,String branch_employee_email,String branch_employee_phone,String branch_employee_title);

    @Modifying
    @Transactional
    @Query(value = "UPDATE branch_employee SET " +
            "name = CASE WHEN :branch_employee_name IS NULL OR :branch_employee_name = '' THEN name ELSE :branch_employee_name END, " +
            "status = CASE WHEN :branch_employee_state IS NULL OR :branch_employee_state = '' THEN status ELSE :branch_employee_state END, "+
            "email = CASE WHEN :branch_employee_email IS NULL OR :branch_employee_email = '' THEN email ELSE :branch_employee_email END, "+
            "phone = CASE WHEN :branch_employee_phone IS NULL OR :branch_employee_phone = '' THEN phone ELSE :branch_employee_phone END, "+
            "title = CASE WHEN :branch_employee_title IS NULL OR :branch_employee_title = '' THEN title ELSE :branch_employee_title END "+
            "WHERE branch_id = :branch_id AND id = :branch_employee_id", nativeQuery = true)
    public void updateBranchEmployee(int branch_id,String branch_employee_id,String branch_employee_name,String branch_employee_state,String branch_employee_email,String branch_employee_phone,String branch_employee_title);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM branch_employee WHERE branch_id = :branch_id AND id = :branch_employee_id",nativeQuery = true)
    public void deleteBranchEmployee(int branch_id,String branch_employee_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE branch_employee SET " +
            "pwd = :branch_employee_pwd " +
            "WHERE branch_id = :branch_id AND id = :branch_employee_id",nativeQuery = true)
    public void updateBranchEmployeePwd(int branch_id,String branch_employee_id,String branch_employee_pwd);

    @Query(value = "SELECT * FROM branch_employee where branch_id = :branch_id AND id = :branch_employee_id", nativeQuery = true)
    public BranchEmployee getBranchEmployeeById(int branch_id,String branch_employee_id);

    @Query(value = "SELECT * FROM branch_employee where branch_id = :branch_id",nativeQuery = true)
    public List<BranchEmployee> getAllBranchEmployee(int branch_id);
}
