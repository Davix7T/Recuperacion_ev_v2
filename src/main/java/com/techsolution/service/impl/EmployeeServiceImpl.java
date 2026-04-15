package com.techsolution.service.impl;

import com.techsolution.dto.EmployeeRequest;
import com.techsolution.dto.EmployeeResponse;
import com.techsolution.entity.Department;
import com.techsolution.entity.Employee;
import com.techsolution.repository.DepartmentRepository;
import com.techsolution.repository.EmployeeRepository;
import com.techsolution.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository repository,
                               DepartmentRepository departmentRepository) {
        this.repository = repository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public EmployeeResponse create(EmployeeRequest request) {
        Department department = departmentRepository.findById(request.getDepartmentId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Department not found"));

        Employee e = new Employee();
        e.setName(request.getName());
        e.setPosition(request.getPosition());
        e.setSalary(request.getSalary());
        e.setDepartment(department);

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
        r.setDepartmentId(e.getDepartment().getId());
        return r;
    }
}