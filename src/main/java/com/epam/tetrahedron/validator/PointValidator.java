package com.epam.tetrahedron.validator;

import java.util.List;

public class PointValidator {

    private static final int COORDINATE_COUNT = 12;

    private PointValidator() {}

    public static boolean isCoordinateListValid(List<Double> coordinates) {
        return coordinates != null && coordinates.size() == COORDINATE_COUNT;
    }
}
