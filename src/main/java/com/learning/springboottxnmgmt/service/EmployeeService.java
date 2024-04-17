package com.learning.springboottxnmgmt.service;

import com.learning.springboottxnmgmt.model.Employee;
import com.learning.springboottxnmgmt.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent())
            employee = optional.get();
        else
            throw new RuntimeException(
                    "Employee not found for id : " + id);
        return employee;
    }

    public Employee insertAndUpdate(Employee employee) {
        employeeRepository.save(employee);
        int i=10/0;
        employee.setName("updated name");
        return updateEmployee(employee);
    }


    public Employee updateEmployee(Employee employee) {
        Optional<Employee> mayBeEmployee = employeeRepository.findById(employee.getId());
        if(mayBeEmployee.isPresent()) {
            mayBeEmployee.get().setEmail(employee.getEmail());
            mayBeEmployee.get().setId(employee.getId());
            mayBeEmployee.get().setName(employee.getName());
            employeeRepository.save(mayBeEmployee.get());
            return mayBeEmployee.get();
        }
        return employee;
    }
}
