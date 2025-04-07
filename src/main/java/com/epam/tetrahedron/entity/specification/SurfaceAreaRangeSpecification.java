package com.epam.tetrahedron.entity.specification;

import com.epam.tetrahedron.entity.Tetrahedron;

public class SurfaceAreaRangeSpecification implements Specification {
    private final double minSurfaceArea;
    private final double maxSurfaceArea;

    public SurfaceAreaRangeSpecification(double minSurfaceArea, double maxSurfaceArea) {
        this.minSurfaceArea = minSurfaceArea;
        this.maxSurfaceArea = maxSurfaceArea;
    }

    @Override
    public boolean isSatisfiedBy(Tetrahedron tetrahedron) {
        double surfaceArea = TetrahedronService.calculateSurfaceArea(tetrahedron);
        return surfaceArea >= minSurfaceArea && surfaceArea <= maxSurfaceArea;
    }
}

