package com.freedom.employee.employeerestapi;

import com.freedom.employee.employeerestapi.models.Department;
import com.freedom.employee.employeerestapi.models.Employee;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadEmployeeData {

    @Bean
    CommandLineRunner initDataSet(EmployeeRepository eRepo, DepartmentRepository dRepo){
        log.info("Preloading Employee Data Sets...");
        Department dept1 = new Department("Justice League");
        Department dept2 = new Department("Freelancers");
        return args -> {
            dRepo.save(dept1);
            dRepo.save(dept2);

            eRepo.save(new Employee("Eric","Zipple","zippleer@gmail.com", dept1));
            eRepo.save(new Employee("Clark","Kent","TotallyNotSuperman@gmail.com", dept1));
            eRepo.save(new Employee("Karen","Starr","TotallyNotPowerGirl@gmail.com", dept2));
            eRepo.save(new Employee("Bruce","Wayne","TotallyNotBatman@gmail.com", dept1));
            eRepo.save(new Employee("Selina","Kyle","TotallyNotCatwoman@gmail.com", dept2));
            eRepo.save(new Employee("Barry","Allen","TotallyNotTheFlash@gmail.com", dept1));
            eRepo.save(new Employee("Diana","Prince","TotallyNotWonderWoman@gmail.com", dept1));
            eRepo.save(new Employee("Billy","Batson","TotallyNotShazam@gmail.com", dept1));
            eRepo.save(new Employee("Richard","Grayson","TotallyNotRobin@gmail.com", dept2));
        };

    }
}
