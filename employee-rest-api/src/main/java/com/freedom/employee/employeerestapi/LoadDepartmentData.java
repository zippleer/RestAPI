/**

package com.freedom.employee.employeerestapi;

import com.freedom.employee.employeerestapi.models.Department;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDepartmentData {

    @Bean
    CommandLineRunner initDataSet(DepartmentRepository repo){
        log.info("Preloading Department Data Sets");
        String jL = "Justice League";
        return args-> {
            repo.save(new Department("Justice League"));
            repo.save(new Department("Freelancers"));
        };
    }
}
**/