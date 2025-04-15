package com.epam.tetrahedron.warehouse;

public class TetrahedronParameters {
    private final double volume;
    private final double surfaceArea;

    public TetrahedronParameters(double volume, double surfaceArea) {
        this.volume = volume;
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    @Override
    public String toString() {
        return "TetrahedronParameters{" +
                "volume=" + volume +
                ", surfaceArea=" + surfaceArea +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TetrahedronParameters)) return false;

        TetrahedronParameters that = (TetrahedronParameters) o;

        return Double.compare(volume, that.volume) == 0 &&
                Double.compare(surfaceArea, that.surfaceArea) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(volume);
        result = 31 * result + Double.hashCode(surfaceArea);
        return result;
    }
}
