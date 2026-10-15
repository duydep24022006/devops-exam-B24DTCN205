
package com.ptit.devops.lab.controller;

import com.ptit.devops.lab.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/employees/count")
    public long countEmployees() {
        return repository.count();
    }
}
