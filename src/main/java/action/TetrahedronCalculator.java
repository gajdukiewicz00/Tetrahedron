package action;

import entity.Point;
import entity.Tetrahedron;

public class TetrahedronCalculator {

    public static double calculateVolume(Tetrahedron tetrahedron) {
        Point[] vertices = tetrahedron.getVertices();
        double volume = Math.abs(
                (vertices[0].getX() * (vertices[1].getY() * vertices[2].getZ() - vertices[2].getY() * vertices[1].getZ())) -
                        (vertices[1].getX() * (vertices[0].getY() * vertices[2].getZ() - vertices[2].getY() * vertices[0].getZ())) +
                        (vertices[2].getX() * (vertices[0].getY() * vertices[1].getZ() - vertices[1].getY() * vertices[0].getZ()))
        ) / 6.0;
        return volume;
    }

    public static double calculateSurfaceArea(Tetrahedron tetrahedron) {
        Point[] vertices = tetrahedron.getVertices();
        double sideLength = distance(vertices[0], vertices[1]);
        return Math.sqrt(3) * Math.pow(sideLength, 2);
    }

    private static double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) +
                Math.pow(a.getY() - b.getY(), 2) +
                Math.pow(a.getZ() - b.getZ(), 2));
    }
}
