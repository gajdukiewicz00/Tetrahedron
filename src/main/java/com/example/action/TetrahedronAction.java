package com.example.action;

import com.example.entity.Point;
import com.example.entity.Tetrahedron;
import com.example.validator.TetrahedronLogicValidator;

/**
 * Класс бизнес-логики для операций с тетраэдром.
 */
public class TetrahedronAction {

    /**
     * Вычислить площадь поверхности тетраэдра = сумма площадей его 4 граней.
     */
    public static double calculateSurfaceArea(Tetrahedron tetrahedron) {
        Point a = tetrahedron.getPointA();
        Point b = tetrahedron.getPointB();
        Point c = tetrahedron.getPointC();
        Point d = tetrahedron.getPointD();

        double areaABC = triangleArea(a, b, c);
        double areaABD = triangleArea(a, b, d);
        double areaACD = triangleArea(a, c, d);
        double areaBCD = triangleArea(b, c, d);

        double totalArea = areaABC + areaABD + areaACD + areaBCD;
        return totalArea;
    }

    /**
     * Вычислить объём тетраэдра через скалярное тройное произведение.
     */
    public static double calculateVolume(Tetrahedron tetrahedron) {
        Point a = tetrahedron.getPointA();
        Point b = tetrahedron.getPointB();
        Point c = tetrahedron.getPointC();
        Point d = tetrahedron.getPointD();

        double[] ab = {b.getX() - a.getX(), b.getY() - a.getY(), b.getZ() - a.getZ()};
        double[] ac = {c.getX() - a.getX(), c.getY() - a.getY(), c.getZ() - a.getZ()};
        double[] ad = {d.getX() - a.getX(), d.getY() - a.getY(), d.getZ() - a.getZ()};

        // Векторное произведение ab x ac
        double[] cross = {
                ab[1] * ac[2] - ab[2] * ac[1],
                ab[2] * ac[0] - ab[0] * ac[2],
                ab[0] * ac[1] - ab[1] * ac[0]
        };

        // Скалярное произведение cross ⋅ ad
        double scalar = cross[0] * ad[0] + cross[1] * ad[1] + cross[2] * ad[2];

        // Модуль делим на 6
        double volume = Math.abs(scalar) / 6.0;
        return volume;
    }

    /**
     * Проверка, что тетраэдр не вырожден (объём > 0).
     */
    public static boolean isValidTetrahedron(Tetrahedron tetrahedron) {
        double volume = calculateVolume(tetrahedron);
        return TetrahedronLogicValidator.isVolumePositive(volume);
    }

    /**
     * Проверить, лежит ли грань ABC на плоскости XY (z=0).
     * Условно считаем "основанием" грань ABC.
     */
    public static boolean isBaseOnCoordinatePlaneXY(Tetrahedron tetrahedron) {
        Point a = tetrahedron.getPointA();
        Point b = tetrahedron.getPointB();
        Point c = tetrahedron.getPointC();
        return a.getZ() == 0.0 && b.getZ() == 0.0 && c.getZ() == 0.0;
    }

    /**
     * Пример вычисления (или оценки) соотношения объёмов при рассечении Z=0.
     * Здесь приведён упрощённый подход (демонстрация).
     */
    public static double volumeRatioWithPlaneZ(Tetrahedron tetrahedron) {
        Point a = tetrahedron.getPointA();
        Point b = tetrahedron.getPointB();
        Point c = tetrahedron.getPointC();
        Point d = tetrahedron.getPointD();

        // Упрощённо проверим, все ли точки выше/ниже, чтобы вернуть условные значения:
        boolean aboveA = (a.getZ() >= 0);
        boolean aboveB = (b.getZ() >= 0);
        boolean aboveC = (c.getZ() >= 0);
        boolean aboveD = (d.getZ() >= 0);

        boolean allAbove = aboveA && aboveB && aboveC && aboveD;
        boolean allBelow = !aboveA && !aboveB && !aboveC && !aboveD;

        if (allAbove) {
            // Всё над плоскостью => нижняя часть = 0 => отношение "выше/ниже" = ∞
            return Double.POSITIVE_INFINITY;
        }

        if (allBelow) {
            // Всё под плоскостью => верхняя часть = 0 => отношение = 0
            return 0.0;
        }

        // Частично выше, частично ниже => например, условно 2.0 (демо).
        return 2.0;
    }

    /**
     * Площадь треугольника (ABC) = 1/2 |AB x AC|
     */
    private static double triangleArea(Point p1, Point p2, Point p3) {
        double[] v1 = { p2.getX() - p1.getX(), p2.getY() - p1.getY(), p2.getZ() - p1.getZ() };
        double[] v2 = { p3.getX() - p1.getX(), p3.getY() - p1.getY(), p3.getZ() - p1.getZ() };

        double[] cross = {
                v1[1] * v2[2] - v1[2] * v2[1],
                v1[2] * v2[0] - v1[0] * v2[2],
                v1[0] * v2[1] - v1[1] * v2[0]
        };

        double area = 0.5 * Math.sqrt(cross[0]*cross[0] + cross[1]*cross[1] + cross[2]*cross[2]);
        return area;
    }
}
