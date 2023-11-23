package com.tomslabs.exercises.chapter2;

import java.io.PrintStream;
import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.lang.System.out;
import static java.time.LocalDate.now;

public class Exercise12 {
    private record Calendar(LocalDate date, PrintStream outStream) {
        private static final String DAYS_SEPARATOR = "\t";

        public void printCalendar() {
            printHeader();
            printDays();
        }

        private void printHeader() {
            for (int i = 7; i != 0; i = (i + 1) % 7) {
                outStream.print(DayOfWeek.of(i).toString().substring(0, 3) + " ");
            }
            outStream.println();
        }

        private void printDays() {
            final LocalDate monthStart = LocalDate.of(date.getYear(), date.getMonth(), 1);
            printInitOffset(monthStart);

            LocalDate currentDay = monthStart;
            while (currentDay.getMonth() == date.getMonth()) {
                if (currentDay.getDayOfWeek() == DayOfWeek.SUNDAY)
                    outStream.println();

                outStream.print(currentDay.getDayOfMonth() + DAYS_SEPARATOR);
                currentDay = currentDay.plusDays(1);
            }
        }

        private void printInitOffset(LocalDate monthStart) {
            DayOfWeek startDayWeekday = monthStart.getDayOfWeek();
            for (int i = 1; i <= startDayWeekday.getValue(); i++)
                outStream.print(DAYS_SEPARATOR);
        }
    }

    public static void main(String[] args) {
        new Calendar(now(), out).printCalendar();
    }
}
