package com.epam.tetrahedron.validator;

import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TetrahedronValidatorTest {

    @Test
    public void testValidTetrahedronGeometry() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0, 1, 0);
        Point d = new Point(0, 0, 1);
        Tetrahedron tetrahedron = new Tetrahedron(1, a, b, c, d);
        boolean isValid = TetrahedronValidator.isTetrahedronGeometryValid(tetrahedron);
        Assert.assertTrue(isValid);
    }

    @Test
    public void testInvalidTetrahedronGeometry() {
        Point a = new Point(1, 1, 1);
        Point b = new Point(2, 2, 2);
        Point c = new Point(3, 3, 3);
        Point d = new Point(4, 4, 4);
        Tetrahedron tetrahedron = new Tetrahedron(2, a, b, c, d);
        boolean isValid = TetrahedronValidator.isTetrahedronGeometryValid(tetrahedron);
        Assert.assertFalse(isValid);
    }

    @Test
    public void testCoordinateListValidation() {
        List<Double> correct = Arrays.asList(
                0.0, 0.0, 0.0,
                1.0, 0.0, 0.0,
                0.0, 1.0, 0.0,
                0.0, 0.0, 1.0
        );
        List<Double> incorrect = Arrays.asList(1.0, 2.0); // мало координат

        Assert.assertTrue(PointValidator.isCoordinateListValid(correct));
        Assert.assertFalse(PointValidator.isCoordinateListValid(incorrect));
    }
}
