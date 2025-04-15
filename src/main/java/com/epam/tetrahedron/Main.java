package com.epam.tetrahedron;

import com.epam.tetrahedron.entity.Tetrahedron;
import com.epam.tetrahedron.exception.TetrahedronException;
import com.epam.tetrahedron.factory.TetrahedronFactory;
import com.epam.tetrahedron.observer.WarehouseObserver;
import com.epam.tetrahedron.parser.TetrahedronParser;
import com.epam.tetrahedron.reader.TetrahedronReader;
import com.epam.tetrahedron.repository.TetrahedronRepository;
import com.epam.tetrahedron.repository.specification.VolumeGreaterThanSpecification;
import com.epam.tetrahedron.validator.PointValidator;
import com.epam.tetrahedron.warehouse.Warehouse;
import com.epam.tetrahedron.observer.TetrahedronEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Paths;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Application started");

        String relativePath = "resources/input.txt";
        TetrahedronReader reader = new TetrahedronReader();
        TetrahedronParser parser = new TetrahedronParser();
        TetrahedronFactory factory = new TetrahedronFactory();
        TetrahedronRepository repository = new TetrahedronRepository();
        WarehouseObserver observer = new WarehouseObserver();
        Warehouse warehouse = Warehouse.getInstance();

        try {
            List<String> lines = reader.readLines(Paths.get(relativePath));
            logger.info("Loaded {} lines from input file", lines.size());

            for (String line : lines) {
                List<Double> coordinates = parser.parseLine(line);

                if (!PointValidator.isCoordinateListValid(coordinates)) {
                    logger.warn("Skipping invalid line: {}", line);
                    continue;
                }

                try {
                    Tetrahedron tetrahedron = factory.createTetrahedron(coordinates);
                    tetrahedron.attach(observer);
                    repository.add(tetrahedron);
                    observer.update(new TetrahedronEvent(tetrahedron));
                } catch (TetrahedronException e) {
                    logger.error("Skipping invalid tetrahedron: {}", e.getMessage());
                }
            }

            logger.info("Finished loading tetrahedrons. Total valid: {}", repository.getAll().size());

            logger.info("\n--- Warehouse contents ---");
            for (Tetrahedron t : repository.getAll()) {
                warehouse.get(t.getId()).ifPresent(params ->
                        logger.info("ID: {} => {}", t.getId(), params)
                );
            }

            logger.info("\n--- Tetrahedrons with volume > 100 ---");
            List<Tetrahedron> bigOnes = repository.query(new VolumeGreaterThanSpecification(100.0));
            bigOnes.forEach(t -> logger.info(t.toString()));

        } catch (TetrahedronException e) {
            logger.error("Fatal error during application run", e);
        }
    }
}
