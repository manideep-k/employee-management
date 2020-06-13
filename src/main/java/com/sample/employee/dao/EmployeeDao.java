package com.sample.employee.dao;

import com.sample.employee.model.Employee;
import com.sample.employee.respository.EmployeeRepository;
import com.sample.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDao implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployeeDetails() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeDetails(Long id) throws Exception {
        Optional<Employee> employee = repository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new Exception("Employee not found!");
    }

    @Override
    public Employee createOrSaveEmployee(Employee newEmployee) {
        return repository.save(newEmployee);
    }

    @Override
    public Employee updateEmployee(Employee newEmployee, Long id) {
        return repository.findById(id).map(employee -> {
            employee.setFirstName(newEmployee.getFirstName());
            employee.setLastName(newEmployee.getLastName());
            employee.setEmail(newEmployee.getEmail());
            return repository.save(employee);
        }).orElseGet(() -> {
            newEmployee.setId(id);
            return repository.save(newEmployee);
        });
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }

}
