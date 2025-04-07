package com.epam.tetrahedron.servis;

import com.epam.tetrahedron.action.TetrahedronCalculator;
import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.entity.TetrahedronParameters;

public class TetrahedronService {

    private final TetrahedronWarehouse warehouse;

    public TetrahedronService(TetrahedronWarehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void calculateAndStoreParameters(Tetrahedron tetrahedron) {
        double volume = TetrahedronCalculator.calculateVolume(tetrahedron);
        double perimeter = calculatePerimeter(tetrahedron);
        double surfaceArea = calculateSurfaceArea(tetrahedron);

        TetrahedronParameters parameters = new TetrahedronParameters(volume, perimeter, surfaceArea);
        warehouse.put(tetrahedron.getId(), parameters);
    }

    public double calculatePerimeter(Tetrahedron tetrahedron) {
        Point[] v = tetrahedron.getVertices();
        return distance(v[0], v[1]) + distance(v[0], v[2]) + distance(v[0], v[3]) +
                distance(v[1], v[2]) + distance(v[1], v[3]) + distance(v[2], v[3]);
    }

    public double calculateSurfaceArea(Tetrahedron tetrahedron) {
        Point[] v = tetrahedron.getVertices();
        return triangleArea(v[0], v[1], v[2]) +
                triangleArea(v[0], v[1], v[3]) +
                triangleArea(v[0], v[2], v[3]) +
                triangleArea(v[1], v[2], v[3]);
    }

    private double triangleArea(Point a, Point b, Point c) {
        double ab = distance(a, b);
        double bc = distance(b, c);
        double ca = distance(c, a);
        double s = (ab + bc + ca) / 2;
        return Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) +
                Math.pow(p1.getY() - p2.getY(), 2) +
                Math.pow(p1.getZ() - p2.getZ(), 2));
    }
}
