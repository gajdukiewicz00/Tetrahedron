package com.epam.tetrahedron.exception;

public class TetrahedronException extends Exception {

    public TetrahedronException() {
        super();
    }

    public TetrahedronException(String message) {
        super(message);
    }

    public TetrahedronException(String message, Throwable cause) {
        super(message, cause);
    }

    public TetrahedronException(Throwable cause) {
        super(cause);
    }
}
