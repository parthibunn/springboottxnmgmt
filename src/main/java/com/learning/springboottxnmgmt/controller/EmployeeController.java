package com.learning.springboottxnmgmt.controller;

import com.learning.springboottxnmgmt.service.EmployeeService;
import com.learning.springboottxnmgmt.model.Employee;
import com.learning.springboottxnmgmt.service.EmployeeServiceExtn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeServiceExtn employeeServiceExtn;

    @PostMapping("update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("getEmployee/{id}")
    public Employee getEmployee(@RequestParam Long id) {
        return employeeService.getById(id);
    }

    @GetMapping("save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @PostMapping("transact")
    public Employee insertAndUpdate(@RequestBody Employee employee) {
        return employeeService.insertAndUpdate(employee);
    }

    @PostMapping("transactProgram")
    public Employee insertAndUpdateProgram(@RequestBody Employee employee) {
        return employeeServiceExtn.insertAndUpdate(employee);
    }

}
