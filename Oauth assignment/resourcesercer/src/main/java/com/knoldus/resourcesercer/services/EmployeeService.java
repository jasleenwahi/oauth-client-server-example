package com.knoldus.resourcesercer.services;

import com.knoldus.resourcesercer.model.Employee;
import org.springframework.stereotype.Service;
import java.util.List;


public interface EmployeeService {

    public List<Employee> getAllEmployee();


}
