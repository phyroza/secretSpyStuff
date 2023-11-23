package com.tomslabs.exercises.chapter2;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Exercise1 {
    private static class Calendar {
        private static final String DAYS_SEPARATOR = "\t";

        public static void displayCalendar(LocalDate date) {
            printHeader();
            printDays(date);
        }

        private static void printHeader() {
            for (int i = 7; i != 0; i = (i + 1) % 7) {
                System.out.print(DayOfWeek.of(i).toString().substring(0, 3) + " ");
            }
            System.out.println();
        }

        private static void printDays(LocalDate date) {
            final LocalDate monthStart = LocalDate.of(date.getYear(), date.getMonth(), 1);
            printInitOffset(monthStart);

            LocalDate currentDay = monthStart;
            while (currentDay.getMonth() == date.getMonth()) {
                if (currentDay.getDayOfWeek() == DayOfWeek.SUNDAY)
                    System.out.println();

                System.out.print(currentDay.getDayOfMonth() + DAYS_SEPARATOR);
                currentDay = currentDay.plusDays(1);
            }
        }

        private static void printInitOffset(LocalDate monthStart) {
            DayOfWeek startDayWeekday = monthStart.getDayOfWeek();
            for (int i = 1; i <= startDayWeekday.getValue(); i++)
                System.out.print(DAYS_SEPARATOR);
        }
    }

    public static void main(String[] args) {
        Calendar.displayCalendar(LocalDate.now());
    }
}
