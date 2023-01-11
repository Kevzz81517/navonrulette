package com.navonmesh.navonrulette.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class ApplicationException extends RuntimeException {

    public ApplicationException(String message) {
        super(message);
    }
}
