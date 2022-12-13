package hw.unit2;

public class Solution {
    public static void main(String[] args){

        Monster sender = new Monster(Boolean.TRUE);
        int counter = 0;

       while (counter<6) {
           Monster recipient = new Monster();
           if (sender.sendMessage(recipient)){
               counter++;
               sender = recipient;
           }

       }
    }
}
