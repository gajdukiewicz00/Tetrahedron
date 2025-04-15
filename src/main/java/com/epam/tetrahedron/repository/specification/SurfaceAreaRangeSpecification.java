package com.epam.tetrahedron.repository.specification;

import com.epam.tetrahedron.action.TetrahedronService;
import com.epam.tetrahedron.entity.Tetrahedron;

public class SurfaceAreaRangeSpecification implements Specification<Tetrahedron> {
    private final double minArea;
    private final double maxArea;
    private final TetrahedronService service = new TetrahedronService();

    public SurfaceAreaRangeSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specified(Tetrahedron item) {
        double area = service.calculateSurfaceArea(item);
        return area >= minArea && area <= maxArea;
    }
}