package com.example.exception;

/**
 * Базовое пользовательское исключение для тетраэдра.
 */
public class TetrahedronException extends Exception {
    public TetrahedronException(String message) {
        super(message);
    }

    public TetrahedronException(String message, Throwable cause) {
        super(message, cause);
    }
}
