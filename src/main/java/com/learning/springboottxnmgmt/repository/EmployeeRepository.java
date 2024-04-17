package com.learning.springboottxnmgmt.repository;

import com.learning.springboottxnmgmt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
