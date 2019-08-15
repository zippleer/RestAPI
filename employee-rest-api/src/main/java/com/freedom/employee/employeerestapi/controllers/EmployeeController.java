package com.freedom.employee.employeerestapi.controllers;



import com.freedom.employee.employeerestapi.EmployeeRepository;
import com.freedom.employee.employeerestapi.exception.ResourceNotFoundException;
import com.freedom.employee.employeerestapi.models.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//Data returned by each method will be written to response body
@RestController
@Api(value="Employee API Operations")
class EmployeeController {

    private final EmployeeRepository repo;

    EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    /**
     * @return List of employees
     */
    //Get all employees
    @ApiOperation(value="Retrieve all employees", response = List.class)
    @GetMapping("/employees")
    List<Employee> all() {
        return repo.findAll();
    }

    /**
     * @param id
     * @return employee
     */
    //Get Single employee given ID
    @ApiOperation(value="Retrieve employee given id", response = Employee.class)
    @GetMapping("/employees/{id}")
    Employee getEmployee(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    /**
     * @param newEmployee
     * @return map to new employee
     */
    //Create a new employee
    @ApiOperation(value="Create a new employee", response = Employee.class)
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repo.save(newEmployee);
    }


    /**
     * @param newEmployee
     * @param id
     * @returnmap to new employee
     */
    @ApiOperation(value="Replace an employee", response = Employee.class)
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repo.findById(id)
                //Replace employee of given id with employee in request
                .map(employee -> {
                    employee.setFirstName(newEmployee.getFirstName());
                    employee.setLastName(newEmployee.getLastName());
                    employee.setEmail(newEmployee.getEmail());
                    employee.setDepartment(newEmployee.getDepartment());
                    return repo.save(employee);
                })
                //If no employee of given id to replace
                //Insert new employee
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repo.save(newEmployee);
                });
    }

    /**
     * @param id
     */
    //Delete employee of matching id
    @ApiOperation(value="Delete an employee")
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repo.deleteById(id);
    }

    /**
     * @param newEmployee
     * @param id
     */
    @ApiOperation(value="Partially update and employee")
    @PatchMapping("/employees/{id}")
    void updateEmployee(@RequestBody Employee newEmployee, Long id) {
        repo.findById(id).map(employee -> {
            employee.setFirstName(newEmployee.getFirstName());
            employee.setLastName(newEmployee.getLastName());
            employee.setEmail(newEmployee.getEmail());
            employee.setDepartment(newEmployee.getDepartment());
            return repo.save(employee);
        });
    }
}