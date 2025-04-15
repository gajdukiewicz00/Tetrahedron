package com.epam.tetrahedron.repository.specification;

import com.epam.tetrahedron.entity.Tetrahedron;

public class IdSpecification implements Specification<Tetrahedron> {
    private final long targetId;

    public IdSpecification(long targetId) {
        this.targetId = targetId;
    }

    @Override
    public boolean specified(Tetrahedron item) {
        return item.getId() == targetId;
    }
}
