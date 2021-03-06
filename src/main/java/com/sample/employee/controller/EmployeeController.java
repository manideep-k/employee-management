package com.sample.employee.controller;

import com.sample.employee.dao.EmployeeDao;
import com.sample.employee.model.Employee;
import com.sample.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee-management", produces = { MediaType.APPLICATION_JSON_VALUE })
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employees")
    public List<Employee> getAllEmployeeDetails() {
        return employeeDao.getAllEmployeeDetails();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeDetails(@PathVariable Long id) throws Exception {
        return employeeDao.getEmployeeDetails(id);
    }

    @PostMapping("/employees")
    public Employee createOrSaveEmployee(@RequestBody Employee newEmployee) {
        return employeeDao.createOrSaveEmployee(newEmployee);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return employeeDao.updateEmployee(newEmployee, id);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeDao.deleteEmployee(id);
    }

}
