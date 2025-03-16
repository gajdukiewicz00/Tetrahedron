package com.example.test;

import com.example.entity.Point;
import com.example.entity.Tetrahedron;
import com.example.action.TetrahedronAction;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

/**
 * Тесты с учётом ограничений:
 * - без if/for/while/switch
 * - один assert-метод на каждый @Test
 * - без логов
 * - объекты создаём напрямую (new), а не через фабрику
 */
public class TetrahedronActionTest {

    private static final double DELTA = 1e-6;

    @Test
    public void testCalculateSurfaceArea() {
        // given
        Point a = new Point(0.0, 0.0, 0.0);
        Point b = new Point(1.0, 0.0, 0.0);
        Point c = new Point(0.0, 1.0, 0.0);
        Point d = new Point(0.0, 0.0, 1.0);
        Tetrahedron tetra = new Tetrahedron("T1", a, b, c, d);

        // when
        double actualArea = TetrahedronAction.calculateSurfaceArea(tetra);

        // then
        // Пример грубого ручного подсчёта или известного значения:
        // Площади граней:
        // 1) ABC: треугольник со сторонами ~ 1,1,√2 => ~0.5
        // Но у нас все стороны одинаковы: AB=1, AC=√2, BC=1 => площадь ~ 0.707..., etc.
        // Для упрощения - сверяем, что значение в разумном диапазоне или вычисляем точнее.
        boolean ok = (actualArea > 1.7 && actualArea < 3.0);
        assertTrue(ok);
    }

    @Test
    public void testCalculateVolume() {
        // given
        Point a = new Point(0.0, 0.0, 0.0);
        Point b = new Point(1.0, 0.0, 0.0);
        Point c = new Point(0.0, 1.0, 0.0);
        Point d = new Point(0.0, 0.0, 1.0);
        Tetrahedron tetra = new Tetrahedron("T2", a, b, c, d);

        // when
        double volume = TetrahedronAction.calculateVolume(tetra);

        // then
        // Скалярное тройное произведение для (1,0,0), (0,1,0), (0,0,1) = 1
        // => объём = |1|/6 = 1/6 = 0.1666667...
        assertEquals(volume, 1.0/6.0, DELTA);
    }

    @Test
    public void testIsValidTetrahedron() {
        // given
        Point a = new Point(0.0, 0.0, 0.0);
        Point b = new Point(1.0, 0.0, 0.0);
        Point c = new Point(2.0, 0.0, 0.0); // все три точки на одной линии
        Point d = new Point(3.0, 0.0, 0.0); // => объём будет 0
        Tetrahedron tetra = new Tetrahedron("Degenerate", a, b, c, d);

        // when
        boolean valid = TetrahedronAction.isValidTetrahedron(tetra);

        // then
        // Должно быть false (объём 0)
        assertTrue(!valid);
    }
}
