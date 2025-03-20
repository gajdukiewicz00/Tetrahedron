package com.epam.tetrahedron.factory;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.InvalidDataException;

public class TetrahedronFactory {

    public static Tetrahedron createTetrahedron(Point[] vertices) throws InvalidDataException {
        if (vertices == null || vertices.length != 4) {
            throw new InvalidDataException("Tetrahedron requires exactly 4 vertices.");
        }
        return new Tetrahedron(vertices);
    }
}
