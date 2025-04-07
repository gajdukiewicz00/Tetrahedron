package com.epam.tetrahedron.entity;

import java.util.Arrays;

public class Tetrahedron {
    private Point[] vertices;
    private int id ;

    public Tetrahedron(Point[] vertices) {
        if (vertices.length != 4) {
            throw new IllegalArgumentException("Tetrahedron must have exactly 4 vertices.");
        }
        this.vertices = vertices;
    }

    public Point[] getVertices() { return vertices; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tetrahedron{");
        sb.append("vertices=").append(Arrays.toString(vertices));
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
