package com.example.exception;

/**
 * Исключение при ошибке формата/валидности данных (например, при чтении из файла).
 */
public class InvalidTetrahedronDataException extends TetrahedronException {
    public InvalidTetrahedronDataException(String message) {
        super(message);
    }

    public InvalidTetrahedronDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
