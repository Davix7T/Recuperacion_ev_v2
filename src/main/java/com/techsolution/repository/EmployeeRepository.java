package com.techsolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.techsolution.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}