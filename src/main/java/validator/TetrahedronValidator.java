package validator;

import entity.Tetrahedron;
import entity.Point;

public class TetrahedronValidator {

    public static boolean isValidTetrahedron(Tetrahedron tetrahedron) {
        Point[] vertices = tetrahedron.getVertices();
        return calculateVolume(vertices) > 0;
    }

    private static double calculateVolume(Point[] vertices) {
        return Math.abs(
                (vertices[0].getX() * (vertices[1].getY() * vertices[2].getZ() - vertices[2].getY() * vertices[1].getZ())) -
                        (vertices[1].getX() * (vertices[0].getY() * vertices[2].getZ() - vertices[2].getY() * vertices[0].getZ())) +
                        (vertices[2].getX() * (vertices[0].getY() * vertices[1].getZ() - vertices[1].getY() * vertices[0].getZ()))
        ) / 6.0;
    }
}
