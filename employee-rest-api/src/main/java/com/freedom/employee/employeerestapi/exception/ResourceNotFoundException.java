package com.freedom.employee.employeerestapi.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Long id){
        super("ID: " + id  + " is not associated with a resource.");
    }
}
