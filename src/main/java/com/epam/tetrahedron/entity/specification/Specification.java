package com.epam.tetrahedron.entity.specification;

import com.epam.tetrahedron.entity.Tetrahedron;

@FunctionalInterface
public interface Specification {
    boolean isSatisfiedBy(Tetrahedron tetrahedron);
}
