package com.epam.tetrahedron.entity.specification;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;

public class VertexCoordinateSpecification implements Specification {
    private final double x;
    private final double y;
    private final double z;

    public VertexCoordinateSpecification(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean isSatisfiedBy(Tetrahedron tetrahedron) {
        for (Point vertex : tetrahedron.getVertices()) {
            if (vertex.getX() == x && vertex.getY() == y && vertex.getZ() == z) {
                return true;
            }
        }
        return false;
    }
}

