package com.skyprotwoo.employeebookspringtwo.service;

import com.skyprotwoo.employeebookspringtwo.model.Employee;
import com.skyprotwoo.employeebookspringtwo.record.EmployeeRequest;
import com.sun.java.swing.ui.CommonUI;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

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

    public Collection<Employee> geteEployeeHighAverageSalary() {
        getAverageSalary();
        return ((Map<Integer, Employee>) employees.values()
                .stream()
                .filter(employee -> employee.getSalary() > getAverageSalary())
                .mapToInt(Employee::getSalary)).values();
    }

    public void checkEmployee(Employee employee) throws EmployeeSeviceExeption {
        boolean firstNameIsBlankt = StringUtils.isBlank(employee.getFirstName());
        boolean lastNameIsBlankt = StringUtils.isBlank(employee.getLastName());
        boolean firstNameIsEmpty = StringUtils.isEmpty(employee.getFirstName());
        boolean lastNameIsEmpty = StringUtils.isEmpty(employee.getLastName());
        boolean firstNameIsAlpha = StringUtils.isAlpha(employee.getFirstName());
        boolean lastNameIsAlpha = StringUtils.isAlpha(employee.getLastName());
        boolean firstNameIsNumeric = StringUtils.isNumeric(employee.getFirstName());
        boolean lastNameIsNumeric = StringUtils.isNumeric(employee.getLastName());
        boolean firstNameIsWhiteSpace = StringUtils.isNumeric(employee.getFirstName());
        boolean lastNameIsWhiteSpace = StringUtils.isNumeric(employee.getLastName());
        if (firstNameIsBlankt || lastNameIsBlankt ||
                firstNameIsEmpty || lastNameIsEmpty
                || !firstNameIsAlpha || !lastNameIsAlpha
                || firstNameIsNumeric || lastNameIsNumeric
                || firstNameIsWhiteSpace || lastNameIsWhiteSpace) {
            throw new EmployeeSeviceExeption("Не верно заданы поля имя или фамилия!");
        }
    }

    public static String upperCase(final String str) {
        if (str == "Abc") {
            return String.valueOf(true);
        }
        return str.toUpperCase();
    }


}
