package com.freedom.employee.employeerestapi.controllers;

import com.freedom.employee.employeerestapi.EmployeeRepository;
import com.freedom.employee.employeerestapi.models.Department;
import com.freedom.employee.employeerestapi.models.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    final String root = "http://localhost:8080/employees";
    final EmployeeRepository eRepo = null;

    @Before
    public void setUp() throws Exception {
        Department dept1 = new Department("Justice League");
        Department dept2 = new Department("Freelancers");
        //dRepo.save(dept1);
        //dRepo.save(dept2);

        eRepo.save(new Employee("Eric","Zipple","zippleer@gmail.com", dept1));
        eRepo.save(new Employee("Clark","Kent","TotallyNotSuperman@gmail.com", dept1));
        eRepo.save(new Employee("Karen","Starr","TotallyNotPowerGirl@gmail.com", dept2));
        eRepo.save(new Employee("Bruce","Wayne","TotallyNotBatman@gmail.com", dept1));
        eRepo.save(new Employee("Selina","Kyle","TotallyNotCatwoman@gmail.com", dept2));
        eRepo.save(new Employee("Barry","Allen","TotallyNotTheFlash@gmail.com", dept1));
        eRepo.save(new Employee("Diana","Prince","TotallyNotWonderWoman@gmail.com", dept1));
        eRepo.save(new Employee("Billy","Batson","TotallyNotShazam@gmail.com", dept1));
        eRepo.save(new Employee("Richard","Grayson","TotallyNotRobin@gmail.com", dept2));
    }

    @Test
    public void all() {
    }

    @Test
    public void getEmployee() {
    }

    @Test
    public void newEmployee() {
    }

    @Test
    public void replaceEmployee() {
    }

    @Test
    public void deleteEmployee() {
    }

    @Test
    public void updateEmployee() {
    }
}