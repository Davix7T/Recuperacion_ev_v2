package com.techsolution.service.impl;

import com.techsolution.dto.EmployeeRequest;
import com.techsolution.dto.EmployeeResponse;
import com.techsolution.entity.Employee;
import com.techsolution.repository.EmployeeRepository;
import com.techsolution.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeResponse create(EmployeeRequest request) {
        Employee e = new Employee();
        e.setName(request.getName());
        e.setPosition(request.getPosition());
        e.setSalary(request.getSalary());
        return toResponse(repository.save(e));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeResponse> list() {
        return repository.findAll().stream().map(this::toResponse).toList();
    }

    private EmployeeResponse toResponse(Employee e) {
        EmployeeResponse r = new EmployeeResponse();
        r.setId(e.getId());
        r.setName(e.getName());
        r.setPosition(e.getPosition());
        r.setSalary(e.getSalary());
        r.setCreatedAt(e.getCreatedAt());
        return r;
    }
}