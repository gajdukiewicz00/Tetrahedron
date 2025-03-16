package com.example.entity;

/**
 * Класс-сущность, описывающий точку в 3D-пространстве.
 * Не содержит бизнес-логики, только поля и переопределённые методы Object.
 */
public class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ", " + z + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            if (!(obj instanceof Point)) {
                return false;
            } else {
                Point other = (Point) obj;
                return x == other.x && y == other.y && z == other.z;
            }
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        long tempX = Double.doubleToLongBits(x);
        long tempY = Double.doubleToLongBits(y);
        long tempZ = Double.doubleToLongBits(z);

        result = 31 * result + (int) (tempX ^ (tempX >>> 32));
        result = 31 * result + (int) (tempY ^ (tempY >>> 32));
        result = 31 * result + (int) (tempZ ^ (tempZ >>> 32));
        return result;
    }
}
