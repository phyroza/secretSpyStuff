package com.tomslabs.exercises.chapter2;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Exercise1 {
    private static class Calendar {
        private static final String DAYS_SEPARATOR = "\t";
        private final LocalDate today = LocalDate.now();

        public void displayCalendar() {
            displayHeader();

            LocalDate currentDay = LocalDate.of(today.getYear(), today.getMonth(), 1);
            DayOfWeek startDayWeekday = currentDay.getDayOfWeek();
            for (int i = 1; i <= startDayWeekday.getValue(); i++)
                System.out.print(DAYS_SEPARATOR);

            while (currentDay.getMonth() == today.getMonth()) {
                if (currentDay.getDayOfWeek() == DayOfWeek.SUNDAY)
                    System.out.println();

                System.out.print(currentDay.getDayOfMonth() + DAYS_SEPARATOR);
                currentDay = currentDay.plusDays(1);
            }
        }

        private void displayHeader() {
            for (int i = 7; i != 0; i = (i + 1) % 7) {
                System.out.print(DayOfWeek.of(i).toString().substring(0, 3) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Calendar().displayCalendar();
    }
}
