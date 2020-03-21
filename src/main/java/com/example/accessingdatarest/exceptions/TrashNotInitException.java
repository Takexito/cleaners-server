package com.example.accessingdatarest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

@ResponseStatus(value = HttpStatus.NOT_MODIFIED)
public class TrashNotInitException  extends RuntimeException implements Supplier<TrashNotInitException> {
    public TrashNotInitException() {
        super("TrashPoint or TrashBin don't init");
    }

    @Override
    public TrashNotInitException get() {
        return this;
    }
}
