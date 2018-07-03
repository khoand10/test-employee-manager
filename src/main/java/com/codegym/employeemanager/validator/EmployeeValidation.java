package com.codegym.employeemanager.validator;

import com.codegym.employeemanager.model.Employee;
import com.codegym.employeemanager.service.EmployeeService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmployeeValidation implements Validator {

    private EmployeeService employeeService;

    public EmployeeValidation(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Employee employee = (Employee) target;
        String name = employee.getName();
        String birthday = employee.getBirthday();
        boolean gender = employee.isGender();
        String phone = employee.getPhone();
        String cmnd = employee.getCmnd();
        String email = employee.getEmail();
        String address = employee.getAddress();

        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "birthday", "birthday.empty");
        ValidationUtils.rejectIfEmpty(errors, "gender", "gender.empty");
        ValidationUtils.rejectIfEmpty(errors, "phone", "phone.empty");
        ValidationUtils.rejectIfEmpty(errors, "address", "address.empty");

        if (!phone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone", "phone.startsWith");
        }

        if (!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")){
            errors.rejectValue("phone", "email.startsWith");
        }

    }
}