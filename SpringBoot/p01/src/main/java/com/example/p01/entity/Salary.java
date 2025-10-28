package com.example.p01.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "salary")
@IdClass(SalaryId.class)
public class Salary {
    @Id
    @Column(name = "employee_id")
    private String employeeId;

    @Id
    @Column(name = "`year_month`")
    private String yearMonth;

    @Column(name = "base_salary")
    private int baseSalary;

    @Column(name = "overtime_pay")
    private int overtimePay;

    @Column(name = "deduction")
    private int deduction;

    @Column(name = "insurance_fee")
    private int insuranceFee;

    @Column(name = "tax_deduction")
    private int taxDeduction;

    @Column(name = "total_salary")
    private int totalSalary;

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getDeduction() {
        return deduction;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(int insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public int getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(int overtimePay) {
        this.overtimePay = overtimePay;
    }

    public int getTaxDeduction() {
        return taxDeduction;
    }

    public void setTaxDeduction(int taxDeduction) {
        this.taxDeduction = taxDeduction;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary = totalSalary;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }
}