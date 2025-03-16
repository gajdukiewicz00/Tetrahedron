package com.example.reader;

import com.example.entity.Tetrahedron;
import com.example.exception.InvalidTetrahedronDataException;
import com.example.factory.AbstractTetrahedronFactory;
import com.example.validator.TetrahedronDataValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для чтения строк из файла (Java8 Streams) и создания объектов Tetrahedron.
 */
public class TetrahedronFileReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(TetrahedronFileReader.class);

    /**
     * Считать все строки из файла в список.
     */
    public List<String> readLines(String filePath) throws InvalidTetrahedronDataException {
        List<String> lines = new ArrayList<>();
        try {
            Files.lines(Paths.get(filePath)).forEach(line -> lines.add(line));
        } catch (Exception e) {
            throw new InvalidTetrahedronDataException("Ошибка чтения файла: " + filePath, e);
        }
        return lines;
    }

    /**
     * Построить список тетраэдров, пропуская некорректные строки (или логируя их).
     */
    public List<Tetrahedron> buildTetrahedronsFromFile(String filePath, AbstractTetrahedronFactory factory)
            throws InvalidTetrahedronDataException {

        List<String> lines = readLines(filePath);
        List<Tetrahedron> result = new ArrayList<>();

        for (String line : lines) {
            // Можно, например, пропускать пустые строки или начинающиеся с # (комментарии)
            if (line.trim().startsWith("#") || line.trim().isEmpty()) {
                continue;
            }

            if (!TetrahedronDataValidator.isValidDataFormat(line)) {
                LOGGER.error("Некорректная строка: {}", line);
                continue;
            }

            String[] tokens = line.trim().split("\\s+");
            String name = tokens[0];
            double x1 = Double.parseDouble(tokens[1]);
            double y1 = Double.parseDouble(tokens[2]);
            double z1 = Double.parseDouble(tokens[3]);
            double x2 = Double.parseDouble(tokens[4]);
            double y2 = Double.parseDouble(tokens[5]);
            double z2 = Double.parseDouble(tokens[6]);
            double x3 = Double.parseDouble(tokens[7]);
            double y3 = Double.parseDouble(tokens[8]);
            double z3 = Double.parseDouble(tokens[9]);
            double x4 = Double.parseDouble(tokens[10]);
            double y4 = Double.parseDouble(tokens[11]);
            double z4 = Double.parseDouble(tokens[12]);

            try {
                Tetrahedron tetra = factory.createTetrahedron(
                        name, x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4
                );
                result.add(tetra);
            } catch (Exception e) {
                LOGGER.error("Не удалось создать Tetrahedron из строки: {}", line, e);
            }
        }
        return result;
    }
}
