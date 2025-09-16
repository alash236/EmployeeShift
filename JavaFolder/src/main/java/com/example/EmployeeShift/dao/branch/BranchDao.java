package com.example.EmployeeShift.dao.branch;

import com.example.EmployeeShift.entity.branch.Branch;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchDao extends JpaRepository<Branch,Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO branch " +
            "(branch_name,branch_location,branch_phone,branch_email) VALUES " +
            "(:branch_name,:branch_location,:branch_phone,:branch_email)",nativeQuery = true)
    public void addBranch(String branch_name,String branch_location,String branch_phone,String branch_email);

    @Query(value = "SELECT * FROM branch WHERE branch_id = :branch_id",nativeQuery = true)
    public Branch getBranchById(int branch_id);
}
