package hw.unit3;

import java.io.IOException;

public class Solution {

    public static void main(String[] args) throws IOException {

        if (args.length < 1) {
            System.out.println("Please choose task as input argument");
            return;
        }

        String task = args[0];

        switch (task) {
            case "first":
                TaskOne.execute();
                break;
            case "second" :
                TaskTwo.execute();
                break;
            case "third":
                TaskThree.execute();
                break;
            default:
                System.out.println("Please choose \"first\" , \"second\" or \"third\" task for execution.");
        }

    }

}
