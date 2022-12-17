package hw.unit2;
import java.util.Random;

public class Monster {
    private int id;
    private boolean isGood;

    public Monster(){
        this(new Random().nextBoolean());
        id = new Random().nextInt(100);
    }

    public Monster(boolean isGood) {
        this.isGood = isGood;
    }

    public int getId() {
        return id;
    }

    public boolean isGood() {
        return isGood;
    }

    public boolean sendMessage (Monster recipient){
        if(recipient.isGood()) {
            System.out.println("Message was send from Monster#" + id + " to Monster#" +recipient.getId());
            return true;
        } else {
            return false;
        }

    }
}
