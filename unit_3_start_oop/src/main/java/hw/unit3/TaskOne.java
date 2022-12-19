package hw.unit3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TaskOne {

    public static void execute() throws IOException {
        System.out.println("Please, enter stupid combination of letters and numbers:");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        int sum = 0;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sum += parseDigit(chars[i]);
        }

        System.out.println("Your sum is: " + sum);
    }

    private static int parseDigit(char character) {
        if (Character.isDigit(character)) {
            int x = Character.digit(character, 10);
            return x;
        } else {
            return 0;
        }

    }
}

