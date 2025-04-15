package com.epam.tetrahedron.repository.specification;

public interface Specification<T> {
    boolean specified(T item);
}
