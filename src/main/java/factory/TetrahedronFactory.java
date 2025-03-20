package factory;

import entity.Point;
import entity.Tetrahedron;
import exception.InvalidDataException;

public class TetrahedronFactory {

    public static Tetrahedron createTetrahedron(Point[] vertices) throws InvalidDataException {
        if (vertices == null || vertices.length != 4) {
            throw new InvalidDataException("Tetrahedron requires exactly 4 vertices.");
        }
        return new Tetrahedron(vertices);
    }
}
