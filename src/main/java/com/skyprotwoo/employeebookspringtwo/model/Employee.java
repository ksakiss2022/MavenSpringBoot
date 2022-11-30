package com.skyprotwoo.employeebookspringtwo.model;

import org.apache.commons.lang3.StringUtils;

public class Employee {
    private static int counter;
    private Integer id;
    private String firstName;
    private String lastName;
    private int department;
    private int salary;

    //UpperCase/LowerCase/SwapCase/Capitalize/Uncapitalize - changes the case of a String
    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;

        this.id = counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
