package com.epam.tetrahedron.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {

    private static final Warehouse INSTANCE = new Warehouse();

    private final Map<Long, TetrahedronParameters> storage = new HashMap<>();

    private Warehouse() {}

    public static Warehouse getInstance() {
        return INSTANCE;
    }

    public void put(Long id, TetrahedronParameters parameters) {
        storage.put(id, parameters);
    }

    public Optional<TetrahedronParameters> get(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public void remove(Long id) {
        storage.remove(id);
    }

    public void clear() {
        storage.clear();
    }

    public boolean contains(Long id) {
        return storage.containsKey(id);
    }
}
