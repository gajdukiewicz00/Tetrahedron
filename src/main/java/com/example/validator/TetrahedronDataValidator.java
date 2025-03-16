package com.example.validator;

/**
 * Валидатор строковых данных для создания Tetrahedron.
 * Пример формата строки:
 *    "Name  0.0 0.0 0.0  1.0 0.0 0.0  0.0 1.0 0.0  0.0 0.0 1.0"
 * => имя + 12 double-значений.
 */
public class TetrahedronDataValidator {

    /**
     * Проверяем, что строка не пустая, имеет 1 (имя) + 12 чисел = 13 токенов
     * и что все 12 последних токенов парсятся в double без ошибок.
     */
    public static boolean isValidDataFormat(String line) {
        if (line == null) {
            return false;
        }

        String trimmed = line.trim();
        if (trimmed.isEmpty()) {
            return false;
        }

        String[] tokens = trimmed.split("\\s+");
        if (tokens.length != 13) {
            return false;
        }

        // Первый токен - имя. Следующие 12 должны быть double
        for (int i = 1; i < tokens.length; i++) {
            try {
                Double.parseDouble(tokens[i]);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
}
