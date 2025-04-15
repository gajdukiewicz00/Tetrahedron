package com.epam.tetrahedron.util;

import com.epam.tetrahedron.entity.Point;

public final class GeometryUtils {

    private GeometryUtils() {
        // utility class
    }

    public static double distance(Point p1, Point p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        double dz = p2.getZ() - p1.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double triangleArea(Point p1, Point p2, Point p3) {
        double a = distance(p1, p2);
        double b = distance(p2, p3);
        double c = distance(p3, p1);
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static double[] vector(Point from, Point to) {
        return new double[]{
                to.getX() - from.getX(),
                to.getY() - from.getY(),
                to.getZ() - from.getZ()
        };
    }

    public static double[] crossProduct(double[] u, double[] v) {
        return new double[]{
                u[1] * v[2] - u[2] * v[1],
                u[2] * v[0] - u[0] * v[2],
                u[0] * v[1] - u[1] * v[0]
        };
    }

    public static double dotProduct(double[] u, double[] v) {
        return u[0] * v[0] + u[1] * v[1] + u[2] * v[2];
    }

    public static double scalarTripleProduct(Point a, Point b, Point c, Point d) {
        double[] ab = vector(a, b);
        double[] ac = vector(a, c);
        double[] ad = vector(a, d);
        double[] cross = crossProduct(ac, ad);
        return dotProduct(ab, cross);
    }

    public static boolean arePointsCoplanar(Point a, Point b, Point c, Point d) {
        double volume = Math.abs(scalarTripleProduct(a, b, c, d)) / 6.0;
        return volume == 0.0;
    }

    public static boolean nearlyEqual(double a, double b, double epsilon) {
        return Math.abs(a - b) < epsilon;
    }
}
