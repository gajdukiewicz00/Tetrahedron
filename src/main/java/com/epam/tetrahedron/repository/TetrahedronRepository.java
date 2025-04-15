package com.epam.tetrahedron.repository;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.specification.Specification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TetrahedronRepository {
    private static final Logger logger = LoggerFactory.getLogger(TetrahedronRepository.class);

    private final List<Tetrahedron> tetrahedrons = new ArrayList<>();

    public void add(Tetrahedron tetrahedron) {
        tetrahedrons.add(tetrahedron);
        logger.info("Tetrahedron added to repository: {}", tetrahedron);
    }

    public void remove(Tetrahedron tetrahedron) {
        tetrahedrons.remove(tetrahedron);
        logger.info("Tetrahedron removed from repository: {}", tetrahedron);
    }

    public void clear() {
        tetrahedrons.clear();
        logger.info("Repository cleared");
    }

    public List<Tetrahedron> query(Specification<Tetrahedron> specification) {
        logger.debug("Querying repository with specification: {}", specification.getClass().getSimpleName());
        List<Tetrahedron> result = tetrahedrons.stream()
                .filter(specification::specified)
                .collect(Collectors.toList());
        logger.info("Query result size: {}", result.size());
        return result;
    }

    public List<Tetrahedron> sort(Comparator<Tetrahedron> comparator) {
        logger.debug("Sorting repository with comparator: {}", comparator);
        return tetrahedrons.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<Tetrahedron> getAll() {
        return new ArrayList<>(tetrahedrons);
    }
}
