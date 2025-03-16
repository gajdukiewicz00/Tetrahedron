package com.example.factory;

import com.example.entity.Tetrahedron;
import com.example.exception.TetrahedronException;

/**
 * Абстрактная фабрика (Factory Method).
 */
public abstract class AbstractTetrahedronFactory {

    public abstract Tetrahedron createTetrahedron(String name,
                                                  double x1, double y1, double z1,
                                                  double x2, double y2, double z2,
                                                  double x3, double y3, double z3,
                                                  double x4, double y4, double z4)
            throws TetrahedronException;
}
