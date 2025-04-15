package com.epam.tetrahedron.entity;

import com.epam.tetrahedron.observer.ObservableTetrahedron;
import com.epam.tetrahedron.observer.TetrahedronEvent;
import com.epam.tetrahedron.observer.TetrahedronObserver;
import com.epam.tetrahedron.exception.TetrahedronException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tetrahedron implements ObservableTetrahedron {
    private static final Logger logger = LoggerFactory.getLogger(Tetrahedron.class);

    private long id;
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    private TetrahedronObserver observer;

    public Tetrahedron(long id, Point a, Point b, Point c, Point d) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public long getId() {
        return id;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

    public void setA(Point a) {
        this.a = a;
        notifyObserver();
    }

    public void setB(Point b) {
        this.b = b;
        notifyObserver();
    }

    public void setC(Point c) {
        this.c = c;
        notifyObserver();
    }

    public void setD(Point d) {
        this.d = d;
        notifyObserver();
    }

    @Override
    public void attach(TetrahedronObserver observer) {
        this.observer = observer;
    }

    @Override
    public void detach() {
        this.observer = null;
    }

    @Override
    public void notifyObserver() {
        if (observer != null) {
            try {
                observer.update(new TetrahedronEvent(this));
            } catch (TetrahedronException e) {
                logger.error("Failed to notify observer for tetrahedron id {}: {}", id, e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "Tetrahedron{" +
                "id=" + id +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tetrahedron)) return false;

        Tetrahedron other = (Tetrahedron) obj;
        return id == other.id &&
                a.equals(other.a) &&
                b.equals(other.b) &&
                c.equals(other.c) &&
                d.equals(other.d);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + a.hashCode();
        result = 31 * result + b.hashCode();
        result = 31 * result + c.hashCode();
        result = 31 * result + d.hashCode();
        return result;
    }
}