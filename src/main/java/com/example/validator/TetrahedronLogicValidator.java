package com.example.validator;

/**
 * Простейший валидатор геометрических параметров.
 * Например, проверка, что объём > 0 (тетраэдр не вырожден).
 */
public class TetrahedronLogicValidator {
    private static final double EPSILON = 1e-12;

    public static boolean isVolumePositive(double volume) {
        return volume > EPSILON;
    }
}
