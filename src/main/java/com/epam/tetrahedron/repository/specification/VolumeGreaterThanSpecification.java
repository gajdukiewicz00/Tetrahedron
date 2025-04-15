package com.epam.tetrahedron.repository.specification;

import com.epam.tetrahedron.action.TetrahedronService;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.TetrahedronException;

public class VolumeGreaterThanSpecification implements Specification<Tetrahedron> {
    private final double threshold;
    private final TetrahedronService service = new TetrahedronService();

    public VolumeGreaterThanSpecification(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean specified(Tetrahedron item) {
        try {
            return service.calculateVolume(item) > threshold;
        } catch (TetrahedronException e) {
            return false;
        }
    }
}
