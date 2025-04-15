package com.epam.tetrahedron.action;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.TetrahedronException;
import com.epam.tetrahedron.util.GeometryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TetrahedronService {
    private static final Logger logger = LoggerFactory.getLogger(TetrahedronService.class);

    public double calculateVolume(Tetrahedron tetrahedron) throws TetrahedronException {
        logger.debug("Calculating volume for tetrahedron id: {}", tetrahedron.getId());
        Point a = tetrahedron.getA();
        Point b = tetrahedron.getB();
        Point c = tetrahedron.getC();
        Point d = tetrahedron.getD();

        double volume = Math.abs(GeometryUtils.scalarTripleProduct(a, b, c, d)) / 6.0;
        if (volume == 0.0) {
            logger.warn("Calculated volume is zero for tetrahedron id: {}", tetrahedron.getId());
            throw new TetrahedronException("Tetrahedron has zero volume (points are coplanar)");
        }
        logger.info("Calculated volume: {} for tetrahedron id: {}", volume, tetrahedron.getId());
        return volume;
    }

    public double calculateSurfaceArea(Tetrahedron tetrahedron) {
        logger.debug("Calculating surface area for tetrahedron id: {}", tetrahedron.getId());

        double area = GeometryUtils.triangleArea(tetrahedron.getA(), tetrahedron.getB(), tetrahedron.getC()) +
                GeometryUtils.triangleArea(tetrahedron.getA(), tetrahedron.getB(), tetrahedron.getD()) +
                GeometryUtils.triangleArea(tetrahedron.getA(), tetrahedron.getC(), tetrahedron.getD()) +
                GeometryUtils.triangleArea(tetrahedron.getB(), tetrahedron.getC(), tetrahedron.getD());

        logger.info("Calculated surface area: {} for tetrahedron id: {}", area, tetrahedron.getId());
        return area;
    }

    public boolean isTetrahedronValid(Tetrahedron tetrahedron) {
        logger.debug("Checking geometry validity for tetrahedron id: {}", tetrahedron.getId());
        try {
            return calculateVolume(tetrahedron) > 0.0;
        } catch (TetrahedronException e) {
            logger.warn("Invalid tetrahedron geometry: {}", e.getMessage());
            return false;
        }
    }
}
