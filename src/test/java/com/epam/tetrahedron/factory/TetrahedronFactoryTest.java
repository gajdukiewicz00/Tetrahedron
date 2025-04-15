package com.epam.tetrahedron.factory;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.TetrahedronException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TetrahedronFactoryTest {
    private TetrahedronFactory factory;

    @BeforeMethod
    public void setUp() {
        factory = new TetrahedronFactory();
    }

    @Test
    public void testCreateValidTetrahedron() throws TetrahedronException {
        List<Double> coords = Arrays.asList(
                0.0, 0.0, 0.0,
                1.0, 0.0, 0.0,
                0.0, 1.0, 0.0,
                0.0, 0.0, 1.0
        );
        Tetrahedron tetrahedron = factory.createTetrahedron(coords);
        Assert.assertNotNull(tetrahedron);
    }

    @Test(expectedExceptions = TetrahedronException.class)
    public void testCreateInvalidTetrahedron() throws TetrahedronException {
        List<Double> coords = Arrays.asList(
                1.0, 1.0, 1.0,
                2.0, 2.0, 2.0,
                3.0, 3.0, 3.0,
                4.0, 4.0, 4.0
        );
        factory.createTetrahedron(coords);
    }
}
