package test.factory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TetrahedronFactoryTest {

    @Test
    public void testCreateValidTetrahedron() {
        Point[] vertices = {
                new Point(0, 0, 0),
                new Point(1, 0, 0),
                new Point(0, 1, 0),
                new Point(0, 0, 1)
        };
        try {
            Tetrahedron tetrahedron = TetrahedronFactory.createTetrahedron(vertices);
            Assert.assertNotNull(tetrahedron, "Tetrahedron should be created successfully");
        } catch (InvalidDataException e) {
            Assert.fail("Unexpected exception during valid tetrahedron creation");
        }
    }

    @Test(expectedExceptions = InvalidDataException.class)
    public void testCreateInvalidTetrahedron() throws InvalidDataException {
        Point[] vertices = new Point[3]; // Недостаточно точек для создания тетраэдра
        TetrahedronFactory.createTetrahedron(vertices);
    }

    @Test
    public void testCreateNullTetrahedron() {
        try {
            TetrahedronFactory.createTetrahedron(null);
            Assert.fail("Exception should have been thrown for null input");
        } catch (InvalidDataException e) {
            Assert.assertEquals(e.getMessage(), "Tetrahedron requires exactly 4 vertices.");
        }
    }
}
