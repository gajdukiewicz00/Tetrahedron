package com.epam.tetrahedron.entity.specification;

import com.epam.tetrahedron.entity.Tetrahedron;

public class EdgeLengthSpecification implements Specification {
    private final double minLength;
    private final double maxLength;

    public EdgeLengthSpecification(double minLength, double maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean isSatisfiedBy(Tetrahedron tetrahedron) {
        double[] edgeLengths = TetrahedronService.getEdgeLengths(tetrahedron);
        for (double length : edgeLengths) {
            if (length >= minLength && length <= maxLength) {
                return true;
            }
        }
        return false;
    }
}

