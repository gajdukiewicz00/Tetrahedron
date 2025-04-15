package com.epam.tetrahedron.observer;

import com.epam.tetrahedron.action.TetrahedronService;
import com.epam.tetrahedron.entity.Point;
import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.TetrahedronException;
import com.epam.tetrahedron.warehouse.TetrahedronParameters;
import com.epam.tetrahedron.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

public class WarehouseObserverTest {

    private Tetrahedron tetrahedron;
    private Warehouse warehouse;
    private WarehouseObserver observer;

    @BeforeMethod
    public void setUp() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 0, 0);
        Point c = new Point(0, 1, 0);
        Point d = new Point(0, 0, 1);
        tetrahedron = new Tetrahedron(100, a, b, c, d);

        observer = new WarehouseObserver();
        warehouse = Warehouse.getInstance();
        warehouse.clear();
    }

    @Test
    public void testWarehouseUpdateOnNotify() throws TetrahedronException {
        tetrahedron.attach(observer);
        tetrahedron.notifyObserver();

        Optional<TetrahedronParameters> maybeParams = warehouse.get(tetrahedron.getId());
        Assert.assertTrue(maybeParams.isPresent());

        TetrahedronService service = new TetrahedronService();
        double expectedVolume = service.calculateVolume(tetrahedron);
        double expectedArea = service.calculateSurfaceArea(tetrahedron);

        TetrahedronParameters actual = maybeParams.get();
        Assert.assertEquals(actual.getVolume(), expectedVolume, 1e-6);
        Assert.assertEquals(actual.getSurfaceArea(), expectedArea, 1e-6);
    }
}
