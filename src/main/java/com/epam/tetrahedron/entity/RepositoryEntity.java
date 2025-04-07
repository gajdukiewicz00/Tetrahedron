package com.epam.tetrahedron.entity;

import com.epam.tetrahedron.entity.specification.Specification;

import java.util.List;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepositoryEntity {
    private final List<Tetrahedron> tetrahedrons = new ArrayList<>();

    public void add(Tetrahedron tetrahedron) {
        tetrahedrons.add(tetrahedron);
    }

    public void remove(Tetrahedron tetrahedron) {
        tetrahedrons.remove(tetrahedron);
    }

    public List<Tetrahedron> query(Specification specification) {
        return tetrahedrons.stream()
                .filter(specification::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    public List<Tetrahedron> sort(Comparator<Tetrahedron> comparator) {
        return tetrahedrons.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}

