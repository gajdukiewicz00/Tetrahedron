package com.epam.tetrahedron.reader;

import com.epam.tetrahedron.exception.TetrahedronException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class TetrahedronReader {
    private static final Logger logger = LoggerFactory.getLogger(TetrahedronReader.class);

    public List<String> readLines(Path filePath) throws TetrahedronException {
        logger.info("Reading file: {}", filePath);

        try {
            List<String> lines = Files.lines(filePath)
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .collect(Collectors.toList());

            logger.info("Successfully read {} lines from file", lines.size());
            return lines;

        } catch (IOException e) {
            logger.error("Error reading file: {}", filePath, e);
            throw new TetrahedronException("Failed to read file: " + filePath, e);
        }
    }
}
