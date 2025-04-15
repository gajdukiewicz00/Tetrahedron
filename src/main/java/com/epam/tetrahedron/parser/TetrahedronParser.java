package com.epam.tetrahedron.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronParser {
    private static final Logger logger = LoggerFactory.getLogger(TetrahedronParser.class);
    private static final String DOUBLE_DELIMITER = "\\s*;\\s*";

    public List<Double> parseLine(String line) {
        logger.debug("Parsing line: {}", line);

        List<Double> coordinates = new ArrayList<>();
        String[] parts = line.trim().split(DOUBLE_DELIMITER);

        for (String part : parts) {
            try {
                double value = Double.parseDouble(part);
                coordinates.add(value);
            } catch (NumberFormatException e) {
                logger.warn("Invalid coordinate found: '{}' in line: {}", part, line);
                return new ArrayList<>(); // строка считается невалидной
            }
        }

        logger.debug("Parsed coordinates: {}", coordinates);
        return coordinates;
    }
}
