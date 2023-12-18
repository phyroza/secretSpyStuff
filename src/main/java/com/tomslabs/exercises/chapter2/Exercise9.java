package com.tomslabs.exercises.javaImpatnient.chapter2;

public class Exercise9 {
    private record TimeOfDay(int hour, int minute) {
        TimeOfDay plusMinutes(int plusMinutes) {
            int newHours = (hour() + plusMinutes / 60) % 24;
            int newMinutes = minute() + plusMinutes % 60;

            return new TimeOfDay(newHours, newMinutes);
        }

        int minutesFrom(TimeOfDay other) {
            int otherFromMidnight = other.hour() * 60 + other.minute();
            int thisFromMidnight = hour() * 60 + minute();

            return Math.abs(otherFromMidnight - thisFromMidnight);
        }
    }

    public static void main(String[] args) {
        TimeOfDay time1 = new TimeOfDay(2, 15);
        TimeOfDay time2 = time1.plusMinutes(756);
        int minutesBetween = time2.minutesFrom(time1);
        System.out.println("minutesBetween t1 and t2 = " + minutesBetween);

        int minuteBetween2 = new TimeOfDay(23, 43).plusMinutes(1).minutesFrom(time1);
        System.out.println("minuteBetween2 = " + minuteBetween2);
    }
}
