package com.example.beanvalidation.dao;

import com.example.beanvalidation.ds.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
