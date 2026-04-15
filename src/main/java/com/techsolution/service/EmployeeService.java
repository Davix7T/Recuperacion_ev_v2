package com.techsolution.service;

import com.techsolution.dto.EmployeeRequest;
import com.techsolution.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse create(EmployeeRequest request);

    List<EmployeeResponse> list();
}