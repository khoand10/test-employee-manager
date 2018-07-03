package com.codegym.employeemanager.service;

import com.codegym.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeService {

    Iterable<Employee> getAll();

    void save(Employee employee);

    Employee findById(Long id);

    void delete(Long id);

    Iterable<Employee> findByName(String keyword);
}
