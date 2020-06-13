package com.sample.employee.service;


import com.sample.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployeeDetails();

    Employee getEmployeeDetails(Long id) throws Exception ;

    Employee createOrSaveEmployee(Employee newEmployee);

    Employee updateEmployee(Employee newEmployee, Long id);

    void deleteEmployee(Long id);

}
