package com.epam.tetrahedron.service;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.TetrahedronException;
import com.epam.tetrahedron.factory.TetrahedronFactory;
import com.epam.tetrahedron.observer.WarehouseObserver;
import com.epam.tetrahedron.parser.TetrahedronParser;
import com.epam.tetrahedron.reader.TetrahedronReader;
import com.epam.tetrahedron.repository.TetrahedronRepository;
import com.epam.tetrahedron.validator.PointValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;
import java.util.List;

public class TetrahedronImporter {
    private static final Logger logger = LoggerFactory.getLogger(TetrahedronImporter.class);

    private final TetrahedronRepository repository;

    public TetrahedronImporter(TetrahedronRepository repository) {
        this.repository = repository;
    }

    public void importFromFile(String path) {
        TetrahedronReader reader = new TetrahedronReader();
        TetrahedronParser parser = new TetrahedronParser();
        TetrahedronFactory factory = new TetrahedronFactory();
        WarehouseObserver observer = new WarehouseObserver();

        try {
            List<String> lines = reader.readLines(Paths.get(path));
            logger.info("Loaded {} lines from file: {}", lines.size(), path);

            for (String line : lines) {
                List<Double> coords = parser.parseLine(line);

                if (!PointValidator.isCoordinateListValid(coords)) {
                    logger.warn("Skipping invalid line: {}", line);
                    continue;
                }

                try {
                    Tetrahedron tetrahedron = factory.createTetrahedron(coords);
                    tetrahedron.attach(observer);
                    repository.add(tetrahedron);
                } catch (TetrahedronException e) {
                    logger.error("Skipping invalid tetrahedron: {}", e.getMessage());
                }
            }

            logger.info("Import completed. Total valid tetrahedrons: {}", repository.getAll().size());

        } catch (TetrahedronException e) {
            logger.error("Failed to import tetrahedrons", e);
        }
    }
}
