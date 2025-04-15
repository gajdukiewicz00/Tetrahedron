package com.epam.tetrahedron.repository.specification;

import com.epam.tetrahedron.entity.Tetrahedron;

import java.util.function.Predicate;

public class CustomPredicateSpecification implements Specification<Tetrahedron> {
    private final Predicate<Tetrahedron> predicate;

    public CustomPredicateSpecification(Predicate<Tetrahedron> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean specified(Tetrahedron item) {
        return predicate.test(item);
    }
}
