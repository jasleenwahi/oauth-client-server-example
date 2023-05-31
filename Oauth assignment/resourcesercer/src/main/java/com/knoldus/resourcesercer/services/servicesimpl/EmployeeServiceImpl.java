package com.knoldus.resourcesercer.services.servicesimpl;

import com.knoldus.resourcesercer.model.Employee;
import com.knoldus.resourcesercer.services.EmployeeService;
import java.util.ArrayList;
import java.util.List;
public class EmployeeServiceImpl implements EmployeeService {

   static List<Employee> employees=new ArrayList<>();

    static {

        employees.add(new Employee(1L,"Rhaul","knoldus"));

    }

    /**
     * Retrieves a list of all employees.
     *
     * @return The list of all employees
     */
    @Override
    public List<Employee> getAllEmployee() {
        return employees;
    }
}
