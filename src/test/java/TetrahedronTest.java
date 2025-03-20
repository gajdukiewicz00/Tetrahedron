import entity.Point;
import entity.Tetrahedron;
import action.TetrahedronCalculator;
import validator.TetrahedronValidator;
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

    @Test
    public void testCalculateSurfaceArea() {
        Point[] vertices = {
                new Point(0, 0, 0),
                new Point(1, 0, 0),
                new Point(0, 1, 0),
                new Point(0, 0, 1)
        };
        Tetrahedron tetrahedron = new Tetrahedron(vertices);
        double area = TetrahedronCalculator.calculateSurfaceArea(tetrahedron);
        Assert.assertEquals(area, 1.732, 0.001);
    }

    @Test
    public void testIsValidTetrahedron() {
        Point[] vertices = {
                new Point(0, 0, 0),
                new Point(1, 0, 0),
                new Point(0, 1, 0),
                new Point(0, 0, 1)
        };
        Tetrahedron tetrahedron = new Tetrahedron(vertices);
        Assert.assertTrue(TetrahedronValidator.isValidTetrahedron(tetrahedron));
    }
}
