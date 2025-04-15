package com.epam.tetrahedron.validator;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.util.GeometryUtils;

public class TetrahedronValidator {

    private TetrahedronValidator() {}

    public static boolean isTetrahedronGeometryValid(Tetrahedron tetrahedron) {
        Point a = tetrahedron.getA();
        Point b = tetrahedron.getB();
        Point c = tetrahedron.getC();
        Point d = tetrahedron.getD();
        return !GeometryUtils.arePointsCoplanar(a, b, c, d);
    }
}
