package com.techsolution.controller;

import com.techsolution.entity.Department;
import com.techsolution.repository.DepartmentRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentRepository repository;

    public DepartmentController(DepartmentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Department create(@RequestBody @Valid DepartmentRequest request) {
        Department d = new Department();
        d.setName(request.name);
        return repository.save(d);
    }

    @GetMapping
    public List<Department> list() {
        return repository.findAll();
    }

    static class DepartmentRequest {
        @NotBlank
        @Size(max = 120)
        public String name;
    }
}