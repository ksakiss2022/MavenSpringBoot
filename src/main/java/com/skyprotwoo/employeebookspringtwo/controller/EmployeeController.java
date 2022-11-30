package com.skyprotwoo.employeebookspringtwo.controller;

import com.skyprotwoo.employeebookspringtwo.model.Employee;
import com.skyprotwoo.employeebookspringtwo.record.EmployeeRequest;
import com.skyprotwoo.employeebookspringtwo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public void createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employees/salary/sum")
    public int getSalarySum() {
        return this.employeeService.getSalarySum();
    }

    @GetMapping("/employees/salary/max")
    public int getSaleryMax() {
        return this.employeeService.getSaleryMax();
    }

    @GetMapping("/employees/salary/min")
    public int getSaleryMin() {
        return this.employeeService.getSaleryMin();
    }

    @GetMapping("/employees/salary/average")
    public double getAverageSalary() {
        return this.employeeService.getAverageSalary();

    }
    @GetMapping("/employees/salary-high-salary")
    public Collection<Employee> employeeHighAverageSalary(){
        return this.employeeService.employeeHighAverageSalary;
    }
}
