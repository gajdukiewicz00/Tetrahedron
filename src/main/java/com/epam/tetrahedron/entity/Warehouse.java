package com.epam.tetrahedron.entity;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final Map<Long, TetrahedronParameters> parametersMap = new HashMap<>();

    public void put(long id, TetrahedronParameters parameters) {
        parametersMap.put(id, parameters);
    }

    public TetrahedronParameters get(long id) {
        return parametersMap.get(id);
    }

    public void remove(long id) {
        parametersMap.remove(id);
    }

    public boolean contains(long id) {
        return parametersMap.containsKey(id);
    }
}

