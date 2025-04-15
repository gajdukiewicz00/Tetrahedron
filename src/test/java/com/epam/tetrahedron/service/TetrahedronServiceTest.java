package com.epam.tetrahedron.service;

import com.epam.tetrahedron.action.TetrahedronService;
import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.TetrahedronException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TetrahedronServiceTest {
    private Tetrahedron tetrahedron;
    private TetrahedronService service;

    @BeforeClass
    public void setUp() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0, 1, 0);
        Point d = new Point(0, 0, 1);
        tetrahedron = new Tetrahedron(1, a, b, c, d);
        service = new TetrahedronService();
    }

    @Test
    public void testCalculateVolume() throws TetrahedronException {
        double volume = service.calculateVolume(tetrahedron);
        Assert.assertEquals(volume, 1.0 / 6.0, 1e-9);
    }

    @Test
    public void testCalculateSurfaceArea() {
        double area = service.calculateSurfaceArea(tetrahedron);
        Assert.assertTrue(area > 0);
    }

    @Test
    public void testIsTetrahedronValid() {
        Assert.assertTrue(service.isTetrahedronValid(tetrahedron));
    }
}
