package com.example.accessingdatarest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException implements Supplier<ObjectNotFoundException> {
    public ObjectNotFoundException(Long id) {
        super("Could not find object with id = " + id);
    }

    @Override
    public ObjectNotFoundException get() {
        return this;
    }
}