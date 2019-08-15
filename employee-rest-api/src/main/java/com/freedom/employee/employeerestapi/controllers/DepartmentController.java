package com.freedom.employee.employeerestapi.controllers;

import com.freedom.employee.employeerestapi.DepartmentRepository;
import com.freedom.employee.employeerestapi.exception.ResourceNotFoundException;
import com.freedom.employee.employeerestapi.models.Department;
import com.freedom.employee.employeerestapi.models.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    private final DepartmentRepository repo;

    public DepartmentController(DepartmentRepository repo) {
        this.repo = repo;
    }

    /**
     * @return List of departments
     */
    //Get all employees
    @GetMapping("/departments")
    List<Department> all() {
        return repo.findAll();
    }

    /**
     * @param id
     * @return department
     */
    //Get Single employee given ID
    @GetMapping("/departments/{id}")
    Department getDepartment(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    /**
     * @param newDepartment
     * @return map to new department
     */
    //Create a new employee
    @PostMapping("/departments")
    Department newDepartment(@RequestBody Department newDepartment) {
        return repo.save(newDepartment);
    }

    /**
     * @param newDepartment
     * @param id
     * @return map to new department
     */
    @PutMapping("/departments/{id}")
    Department replaceDepartment(@RequestBody Department newDepartment, @PathVariable Long id) {

        return repo.findById(id)
                //Replace employee of given id with employee in request
                .map(department -> {
                    department.setDeptName(newDepartment.getDeptName());

                    return repo.save(department);
                })
                //If no employee of given id to replace
                //Insert new employee
                .orElseGet(() -> {
                    newDepartment.setId(id);
                    return repo.save(newDepartment);
                });
    }

    /**
     * @param id
     */
    //Delete department of matching id
    @DeleteMapping("/departments/{id}")
    void deleteDepartment(@PathVariable Long id) {
        repo.deleteById(id);
    }

    /**
     * @param newDepartment
     * @param id
     */
    @PatchMapping("/departments/{id}")
    void updateDepartment(@RequestBody Department newDepartment, Long id) {
        repo.findById(id).map(department -> {
            department.setDeptName(newDepartment.getDeptName());
            return repo.save(department);
        });
    }

}
