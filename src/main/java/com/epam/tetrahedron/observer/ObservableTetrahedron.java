package com.epam.tetrahedron.observer;

public interface ObservableTetrahedron {
    void attach(TetrahedronObserver observer);
    void detach();
    void notifyObserver();
}
