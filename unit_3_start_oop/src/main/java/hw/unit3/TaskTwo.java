package hw.unit3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TaskTwo {
    public static void main(String[] args) throws IOException {
        System.out.println("Please, enter stupid combination of letters and numbers:");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        line = line.replaceAll("(?i)[^А-ЯЁA-Z]", "");
        char[] chars = line.toCharArray();

        Arrays.sort(chars);

        List<CharCount> countedChars = count(chars);
        System.out.println(Arrays.toString(countedChars.toArray()));

    }
    private static List<CharCount> count(char[] chars) {
        List<CharCount> result = new ArrayList<>();

        String s = String.valueOf(chars);
        for (int i = 0; i < chars.length;) {
            char c = chars[i];
            int firstIndex = s.indexOf(c);
            int lastIndex = s.lastIndexOf(c);
            int count = lastIndex - firstIndex +1;
            i+= count;

            result.add(new CharCount(c, count));
        }
        return result;
    }

}
