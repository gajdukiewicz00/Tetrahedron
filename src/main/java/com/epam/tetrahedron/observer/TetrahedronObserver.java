package com.epam.tetrahedron.observer;

import com.epam.tetrahedron.exception.TetrahedronException;

public interface TetrahedronObserver {
    void update(TetrahedronEvent event) throws TetrahedronException;
}
