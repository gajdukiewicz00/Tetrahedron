package com.epam.tetrahedron.service;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.repository.TetrahedronRepository;
import com.epam.tetrahedron.repository.specification.VolumeGreaterThanSpecification;
import com.epam.tetrahedron.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TetrahedronReporter {
    private static final Logger logger = LoggerFactory.getLogger(TetrahedronReporter.class);

    private final TetrahedronRepository repository;
    private final Warehouse warehouse = Warehouse.getInstance();

    public TetrahedronReporter(TetrahedronRepository repository) {
        this.repository = repository;
    }

    public void printWarehouseContents() {
        logger.info("\n--- Warehouse contents ---");
        for (Tetrahedron t : repository.getAll()) {
            warehouse.get(t.getId()).ifPresent(params ->
                    logger.info("ID: {} => {}", t.getId(), params)
            );
        }
    }

    public void printLargeTetrahedrons(double minVolume) {
        logger.info("\n--- Tetrahedrons with volume > {} ---", minVolume);
        List<Tetrahedron> result = repository.query(new VolumeGreaterThanSpecification(minVolume));
        result.forEach(t -> logger.info(t.toString()));
    }
}
