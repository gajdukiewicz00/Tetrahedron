package com.example.factory;

import com.example.entity.Point;
import com.example.entity.Tetrahedron;
import com.example.exception.TetrahedronException;

/**
 * Реализация фабрики тетраэдров.
 */
public class ConcreteTetrahedronFactory extends AbstractTetrahedronFactory {

    @Override
    public Tetrahedron createTetrahedron(String name,
                                         double x1, double y1, double z1,
                                         double x2, double y2, double z2,
                                         double x3, double y3, double z3,
                                         double x4, double y4, double z4)
            throws TetrahedronException {

        Point a = new Point(x1, y1, z1);
        Point b = new Point(x2, y2, z2);
        Point c = new Point(x3, y3, z3);
        Point d = new Point(x4, y4, z4);

        // Тут могут быть дополнительные проверки, если нужно
        // Например, что точки не совпадают, и т.д.

        return new Tetrahedron(name, a, b, c, d);
    }
}
