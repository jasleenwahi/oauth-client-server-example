package com.knoldus.resourcesercer.controller.EmployeeControllerImpl;

import com.knoldus.resourcesercer.controller.EmployeeController;
import com.knoldus.resourcesercer.model.Employee;
import com.knoldus.resourcesercer.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.List;
public class EmployeeControllerImpl implements EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
     * Retrieves a list of all employees.
     *
     * @return ResponseEntity containing the list of employees, or an appropriate error response
     */
    @Override
    public ResponseEntity<List<Employee>> getAllEmployee() {
      return ResponseEntity.ok(employeeService.getAllEmployee());
    }
}
