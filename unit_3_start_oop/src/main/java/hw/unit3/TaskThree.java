package hw.unit3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskThree {
    public static void main(String[] args) throws IOException {
        System.out.println("Please, enter the lesson number from 1 to 10:");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int lessons = Integer.parseInt(bf.readLine());

        int lessonDuration = 45;
        int shortBreak = 5;
        int longBreak = 15;
        int xBreaks = lessons - 1;
        int minutesInHour = 60;

        int totalInMinutes = (lessons * lessonDuration) + (((xBreaks) / 2) * longBreak) + ((((xBreaks) / 2) + ((xBreaks) % 2)) * shortBreak);
        int hours = (totalInMinutes / minutesInHour) + 9;
        int minutes = totalInMinutes % minutesInHour;
        System.out.println("The lesson #" + lessons + " ends at " + hours + " hours and " + minutes + " minutes");

    }
}
