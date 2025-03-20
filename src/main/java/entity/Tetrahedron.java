package entity;

public class Tetrahedron {
    private Point[] vertices;

    public Tetrahedron(Point[] vertices) {
        if (vertices.length != 4) {
            throw new IllegalArgumentException("Tetrahedron must have exactly 4 vertices.");
        }
        this.vertices = vertices;
    }

    public Point[] getVertices() { return vertices; }

    @Override
    public String toString() {
        return "Tetrahedron with vertices: " + vertices[0] + ", " + vertices[1] + ", " + vertices[2] + ", " + vertices[3];
    }
}
