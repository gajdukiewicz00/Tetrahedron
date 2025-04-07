package com.epam.tetrahedron.entity;

public class TetrahedronParameters {
    private final double volume;
    private final double perimeter;
    private final double surfaceArea;

    public TetrahedronParameters(double volume, double perimeter, double surfaceArea) {
        this.volume = volume;
        this.perimeter = perimeter;
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    @Override
    public String toString() {
        return "Volume=" + volume + ", Perimeter=" + perimeter + ", SurfaceArea=" + surfaceArea;
    }
}

