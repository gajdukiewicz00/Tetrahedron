package com.epam.tetrahedron.factory;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.TetrahedronException;
import com.epam.tetrahedron.validator.TetrahedronValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class TetrahedronFactory {
    private static final Logger logger = LoggerFactory.getLogger(TetrahedronFactory.class);
    private static final int POINTS_COUNT = 4;
    private static final int COORDS_PER_POINT = 3;
    private static final int TOTAL_COORDINATES = POINTS_COUNT * COORDS_PER_POINT;

    private static final AtomicLong idGenerator = new AtomicLong(1);

    public Tetrahedron createTetrahedron(List<Double> coordinates) throws TetrahedronException {
        logger.debug("Creating tetrahedron from coordinates: {}", coordinates);

        if (coordinates == null || coordinates.size() != TOTAL_COORDINATES) {
            logger.warn("Invalid number of coordinates: {}", coordinates);
            throw new TetrahedronException("Invalid coordinate list: must contain exactly 12 double values");
        }

        Point a = new Point(coordinates.get(0), coordinates.get(1), coordinates.get(2));
        Point b = new Point(coordinates.get(3), coordinates.get(4), coordinates.get(5));
        Point c = new Point(coordinates.get(6), coordinates.get(7), coordinates.get(8));
        Point d = new Point(coordinates.get(9), coordinates.get(10), coordinates.get(11));

        Tetrahedron tetrahedron = new Tetrahedron(idGenerator.getAndIncrement(), a, b, c, d);
        logger.info("Tetrahedron created with id {}", tetrahedron.getId());

        if (!TetrahedronValidator.isTetrahedronGeometryValid(tetrahedron)) {
            logger.error("Invalid tetrahedron geometry for tetrahedron: {}", tetrahedron);
            throw new TetrahedronException("The given points do not form a valid tetrahedron");
        }

        return tetrahedron;
    }
}