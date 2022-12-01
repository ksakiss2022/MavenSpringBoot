package com.skyprotwoo.employeebookspringtwo.service;

import com.skyprotwoo.employeebookspringtwo.model.Employee;
import com.skyprotwoo.employeebookspringtwo.record.EmployeeRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Значение должно быть заполнено");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());
        this.employees.put(employee.getId(), employee);
        return employee;
    }

    public int getSalarySum() {
        return employees.values().stream().
                mapToInt(Employee::getSalary)
                .sum();
    }

    public int getSaleryMax() {
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .max().orElseThrow(NoSuchElementException::new);
    }

    public int getSaleryMin() {
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .min().orElseThrow(NoSuchElementException::new);
    }

    public double getAverageSalary() {
        return employees.values().stream().
                mapToInt(Employee::getSalary)
                .average().orElseThrow(NoSuchElementException::new);
    }

//    public double egeavarageSalary = employees.values()
//            .stream()
//            .mapToInt(Employee::getSalary)
//            .average()
//            .orElseThrow(NoSuchElementException::new);
   public Collection<Employee> employeeHighAverageSalary = employees.values()
            .stream().filter(e -> e.getSalary() > getAverageSalary())
            .collect(Collectors.toList());

    public void checkEmployee(Employee employee) throws EmployeeSeviceExeption {
        boolean firstNameIsBlankt = StringUtils.isBlank(employee.getFirstName());
        boolean lastNameIsBlankt = StringUtils.isBlank(employee.getLastName());

        if (firstNameIsBlankt || lastNameIsBlankt) {
            throw new EmployeeSeviceExeption("Не верно заданы поля имя или фамилия!");
        }
    }

//    public void checkName(Employee employee) throws EmployeeSeviceExeption {
//        boolean firstNameIsAlpha = StringUtils.isAlpha(employee.getFirstName());
//        boolean lastNameIsAlpha = StringUtils.isAlpha(employee.getLastName());
//
//        if (firstNameIsAlpha || lastNameIsAlpha) {
//            throw new EmployeeSeviceExeption("Не верно заданы поля имя или фамилия!");
//
//        } else {
//            final var firstNameUpperCase = employee.getFirstName() == StringUtils.capitalize("Abc");
//            final var lastNameIsAlphaUpperCase = employee.getLastName() == StringUtils.capitalize("Abc");
//
//        }
//    }



}


