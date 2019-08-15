package com.freedom.employee.employeerestapi;

import com.freedom.employee.employeerestapi.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
