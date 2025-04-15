package com.epam.tetrahedron.repository.specification;

import com.epam.tetrahedron.action.TetrahedronService;
import com.epam.tetrahedron.entity.Tetrahedron;

public class ValidTetrahedronSpecification implements Specification<Tetrahedron> {
    private final TetrahedronService service = new TetrahedronService();

    @Override
    public boolean specified(Tetrahedron item) {
        return service.isTetrahedronValid(item);
    }
}
