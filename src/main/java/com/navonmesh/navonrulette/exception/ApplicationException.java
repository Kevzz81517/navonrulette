package com.navonmesh.navonrulette.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
public class ApplicationException extends RuntimeException {

    private HttpStatus status;

    private Map<String, Object> meta;

    private Throwable throwable;

    public ApplicationException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public ApplicationException(HttpStatus status, String message, Map<String, Object> meta) {
        super(message);
        this.status = status;
        this.meta = meta;
    }

    public ApplicationException(HttpStatus status, Throwable throwable) {
        this.status = status;
        this.throwable = throwable;
    }

    public ApplicationException(HttpStatus status, String message, Throwable throwable) {
        super(message);
        this.status = status;
        this.throwable = throwable;
    }


}
