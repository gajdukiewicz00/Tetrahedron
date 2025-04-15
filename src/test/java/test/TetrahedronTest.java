package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TetrahedronTest {

    @Test
    public void testCalculateVolume() {
        Point[] vertices = {
                new Point(0, 0, 0),
                new Point(1, 0, 0),
                new Point(0, 1, 0),
                new Point(0, 0, 1)
        };
        Tetrahedron tetrahedron = new Tetrahedron(vertices);
        double volume = TetrahedronCalculator.calculateVolume(tetrahedron);
        Assert.assertEquals(volume, 0.1667, 0.0001);
    }

    @Test(expectedExceptions = InvalidDataException.class)
    public void testFactoryWithInvalidData() throws InvalidDataException {
        Point[] vertices = new Point[3];
        TetrahedronFactory.createTetrahedron(vertices);
    }
}
