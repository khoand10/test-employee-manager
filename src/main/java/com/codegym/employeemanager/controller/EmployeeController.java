package com.codegym.employeemanager.controller;

import com.codegym.employeemanager.model.Employee;
import com.codegym.employeemanager.model.Group;
import com.codegym.employeemanager.service.EmployeeService;
import com.codegym.employeemanager.service.GroupService;
import com.codegym.employeemanager.validator.EmployeeValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;
    private GroupService groupService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, GroupService groupService) {
        this.employeeService = employeeService;
        this.groupService = groupService;
    }

    @ModelAttribute("groups")
    public Iterable<Group> getAllFroup() {
        return groupService.getAll();
    }

    @GetMapping("/list")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("/list");
        Iterable<Employee> employees = employeeService.getAll();
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/create");
        new EmployeeValidation(employeeService).validate(employee, bindingResult);
        if (!bindingResult.hasFieldErrors()) {
            employeeService.save(employee);
            modelAndView.addObject("message", "Create new success!");
            modelAndView.addObject("employee", new Employee());
        }
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        Employee employee = employeeService.findById(id);
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/{id}/edit")
    public ModelAndView editEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        new EmployeeValidation(employeeService).validate(employee, bindingResult);
        if (!bindingResult.hasFieldErrors()) {
            employeeService.save(employee);
            modelAndView.addObject("message", "update success!");
            modelAndView.addObject("employee", employee);
        }
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView deleteEmployee(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        employeeService.delete(id);
        modelAndView.setViewName("redirect:/list");

        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam("keyword") String keyword) {
        ModelAndView modelAndView = new ModelAndView("/list");
        Iterable<Employee> employees = employeeService.findByName(keyword);
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

}
