package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import entity.Point;
import entity.Tetrahedron;
import util.LoggerUtil;

public class FileReader {

    public static List<Tetrahedron> readTetrahedrons(String fileName) {
        List<Tetrahedron> tetrahedrons = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] parts = line.split(" ");
                if (parts.length == 12) {
                    try {
                        Point[] vertices = new Point[4];
                        for (int i = 0; i < 4; i++) {
                            double x = Double.parseDouble(parts[i * 3]);
                            double y = Double.parseDouble(parts[i * 3 + 1]);
                            double z = Double.parseDouble(parts[i * 3 + 2]);
                            vertices[i] = new Point(x, y, z);
                        }
                        tetrahedrons.add(new Tetrahedron(vertices));
                    } catch (NumberFormatException e) {
                        LoggerUtil.LOGGER.error("Invalid number format: " + line);
                    }
                } else {
                    LoggerUtil.LOGGER.error("Invalid data length: " + line);
                }
            }
        } catch (IOException e) {
            LoggerUtil.LOGGER.error("Error reading file: " + e.getMessage());
        }
        return tetrahedrons;
    }
}
