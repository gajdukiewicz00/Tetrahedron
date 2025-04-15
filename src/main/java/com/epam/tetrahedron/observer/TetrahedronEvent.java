package com.epam.tetrahedron.observer;

import com.epam.tetrahedron.entity.Tetrahedron;

public class TetrahedronEvent {
    private final Tetrahedron source;

    public TetrahedronEvent(Tetrahedron source) {
        this.source = source;
    }

    public Tetrahedron getSource() {
        return source;
    }
}
