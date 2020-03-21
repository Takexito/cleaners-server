package com.example.accessingdatarest.exceptions;

class EmployeeNotFoundException extends RuntimeException {

    EmployeeNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}