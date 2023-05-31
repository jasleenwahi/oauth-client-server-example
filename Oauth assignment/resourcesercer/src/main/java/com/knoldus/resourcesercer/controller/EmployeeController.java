package com.knoldus.resourcesercer.controller;

import com.knoldus.resourcesercer.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public interface EmployeeController {
    @GetMapping("/getemployees")
    public ResponseEntity<List<Employee>> getAllEmployee();
}
