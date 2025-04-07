package com.epam.tetrahedron.entity.specification;

import com.epam.tetrahedron.action.TetrahedronCalculator;
import com.epam.tetrahedron.entity.Tetrahedron;

public class VolumeRangeSpecification implements Specification {
    private final double minVolume;
    private final double maxVolume;

    public VolumeRangeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean isSatisfiedBy(Tetrahedron tetrahedron) {
        double volume = TetrahedronCalculator.calculateVolume(tetrahedron);
        return volume >= minVolume && volume <= maxVolume;
    }
}
