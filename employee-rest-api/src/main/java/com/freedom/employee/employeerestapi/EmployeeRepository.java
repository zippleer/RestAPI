package com.freedom.employee.employeerestapi;

import com.freedom.employee.employeerestapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
