package com.learning.springboottxnmgmt.service;

import com.learning.springboottxnmgmt.model.Employee;
import com.learning.springboottxnmgmt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Optional;

@Service
public class EmployeeServiceExtn {

    @Autowired
    TransactionTemplate template;

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee insertAndUpdate(Employee employee) {
        template.execute(
                status -> {
                    employeeRepository.save(employee);
                    employee.setName("First Update");
                    return updateEmployee(employee);
                }
        );

        int i=10/0;

        template.execute(
                status -> {
                    employeeRepository.save(employee);
                    employee.setName("Second Update");
                    return updateEmployee(employee);
                }
        );

        return employee;



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
