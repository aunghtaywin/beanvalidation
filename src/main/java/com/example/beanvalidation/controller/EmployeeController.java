package com.example.beanvalidation.controller;

import com.example.beanvalidation.ds.Employee;
import com.example.beanvalidation.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String employeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/employee")
    public String saveEmployee(@Valid Employee employee, BindingResult result){
        if (result.hasErrors()){
            return "employee-form";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String listEmployees(Model model){
        model.addAttribute("employees", employeeService.findAllEmployee());
        return "employee";
    }
}
