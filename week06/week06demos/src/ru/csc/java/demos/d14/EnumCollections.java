package ru.csc.java.demos.d14;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.EnumSet;

public class EnumCollections {

    public static void main(String[] args) {
        EnumSet<DayOfWeek> daySet = EnumSet.noneOf(DayOfWeek.class);
        daySet.add(DayOfWeek.MONDAY);

        EnumMap<DayOfWeek, String> dayNames = new EnumMap<>(DayOfWeek.class);
        dayNames.put(DayOfWeek.MONDAY, "понедельник");
    }
}
