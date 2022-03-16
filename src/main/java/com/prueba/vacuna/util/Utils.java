package com.prueba.vacuna.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static LocalDateTime toLocalDateTime(String date, String format) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern(String.format("%s HH:mm:ss", format));
        return LocalDateTime.parse(String.format("%s 00:00:00", date), formateador);
    }
}
