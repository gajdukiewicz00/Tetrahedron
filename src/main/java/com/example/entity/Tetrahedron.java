package com.example.entity;

/**
 * Класс-сущность, описывающий тетраэдр.
 * Не содержит бизнес-логики, только поля, геттеры и переопределённые методы Object.
 */
public class Tetrahedron {
    private String name;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Tetrahedron(String name, Point pointA, Point pointB, Point pointC, Point pointD) {
        this.name = name;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public String getName() {
        return name;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    @Override
    public String toString() {
        return "Tetrahedron " + name
                + " {A=" + pointA
                + ", B=" + pointB
                + ", C=" + pointC
                + ", D=" + pointD + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            if (!(obj instanceof Tetrahedron)) {
                return false;
            } else {
                Tetrahedron other = (Tetrahedron) obj;
                boolean sameName = false;
                if (this.name == null && other.name == null) {
                    sameName = true;
                } else if (this.name != null && this.name.equals(other.name)) {
                    sameName = true;
                }

                boolean sameA = (this.pointA != null && this.pointA.equals(other.pointA));
                boolean sameB = (this.pointB != null && this.pointB.equals(other.pointB));
                boolean sameC = (this.pointC != null && this.pointC.equals(other.pointC));
                boolean sameD = (this.pointD != null && this.pointD.equals(other.pointD));

                return sameName && sameA && sameB && sameC && sameD;
            }
        }
    }

    @Override
    public int hashCode() {
        int result = 17;
        int nameHash = 0;
        if (name != null) {
            for (int i = 0; i < name.length(); i++) {
                nameHash = 31 * nameHash + name.charAt(i);
            }
        }
        result = 31 * result + nameHash;
        result = 31 * result + (pointA == null ? 0 : pointA.hashCode());
        result = 31 * result + (pointB == null ? 0 : pointB.hashCode());
        result = 31 * result + (pointC == null ? 0 : pointC.hashCode());
        result = 31 * result + (pointD == null ? 0 : pointD.hashCode());
        return result;
    }
}
