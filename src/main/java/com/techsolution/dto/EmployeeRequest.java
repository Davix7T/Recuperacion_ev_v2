package com.techsolution.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class EmployeeRequest {

    @NotBlank(message = "name is required")
    @Size(max = 120, message = "name must be <= 120 chars")
    private String name;

    @NotBlank(message = "position is required")
    @Size(max = 120, message = "position must be <= 120 chars")
    private String position;

    @NotNull(message = "salary is required")
    @PositiveOrZero(message = "salary must be >= 0")
    private Double salary;

    private Long departmentId;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}