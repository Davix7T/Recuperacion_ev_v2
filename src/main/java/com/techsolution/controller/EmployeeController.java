package com.techsolution.controller;

import com.techsolution.dto.EmployeeRequest;
import com.techsolution.dto.EmployeeResponse;
import com.techsolution.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponse create(@Valid @RequestBody EmployeeRequest request) {
        return service.create(request);
    }

    @GetMapping
    public List<EmployeeResponse> list() {
        return service.list();
    }
}