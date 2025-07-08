package cn.lacia.mockcndata.model;

import java.time.LocalDate;

/**
 * @author caoq
 * @since 2025-07-08 11:52
 * 员工信息模型（扩展自Person）
 */
public class Employee extends Person {
    private String employeeId;
    private LocalDate hireDate;
    private double salary;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                "\n员工ID: %s\n入职日期: %s\n薪资: %.2f",
                employeeId, hireDate, salary
        );
    }
}
