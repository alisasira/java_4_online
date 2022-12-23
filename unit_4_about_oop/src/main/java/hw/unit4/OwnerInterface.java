package hw.unit4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OwnerInterface {
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to our house community!");
        System.out.println("Please select your option:");
        String input;
        menu();
        while ((input = reader.readLine()) != null) {
            crud(reader, input);
            menu();
        }
    }

    private void menu() {
        System.out.println("\nIf You want to create a new owner, please enter 1");
        System.out.println("If You want to find an owner, please enter 2");
        System.out.println("If You want to find all owners, please enter 3");
        System.out.println("If You want to update an owner, please enter 4");
        System.out.println("If You want to delete an owner, please enter 5");
        System.out.println("If You want to close application, please enter 6");
    }

    private void crud(BufferedReader reader, String input) throws IOException {
        switch (input) {
            case "1":
                create(reader);
                break;
            case "2":
                findByAptNumber(reader);
                break;
            case "3":
                findAll();
                break;
            case "4":
                updateByAptNumber(reader);
                break;
            case "5":
                deleteByName(reader);
                break;
            case "6":
                stop();
                break;
            case "":
                break;
            default:
                System.out.println("Something went wrong... Try again please");
        }
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Let's create a new owner");
        System.out.println("Please enter owner's name");
        String name = reader.readLine();
        System.out.println("Please enter apartment number");
        String aptNumber = reader.readLine();
        System.out.println("Please enter telephone number");
        String telNumber = reader.readLine();
        System.out.println("Please enter email");
        String email = reader.readLine();
        Owner owner = new Owner();
        owner.setName(name);
        owner.setAptNumber(aptNumber);
        owner.setTelNumber(telNumber);
        owner.setEmail(email);
        OwnerStorage.addOwner(owner);
        System.out.println("Thank you! The owner is created.");
    }

    private void findByAptNumber(BufferedReader reader) throws IOException {
        System.out.println("Let's find owner by apartment number");
        String aptNumber = reader.readLine();
        Owner owner = OwnerStorage.getOwner(aptNumber);
        System.out.println("The owner is " + owner);
    }

    private void findAll() {
        System.out.println("Owners list:");
        Owner[] owners = OwnerStorage.getOwner();
        for(int i = 0; i < owners.length; i++) {
            if(owners[i] != null) {
                System.out.println(owners[i]);
            }
        }
    }

    private void updateByAptNumber(BufferedReader reader) throws IOException {
        System.out.println("Let's update information. To start, please enter apartment number");
        String inputNumber = reader.readLine();
        Owner owner = OwnerStorage.getOwner(inputNumber);
        if (owner == null) {
            System.out.println("This apartment does not exist");
        } else {
            System.out.println("If You want to update name, please enter 1");
            System.out.println("If You want to update telephone number, please enter 2");
            System.out.println("If You want to update email, please enter 3");
            chooseUpdateParameters(reader, owner);
        }
    }

    private void chooseUpdateParameters(BufferedReader reader, Owner owner) throws IOException {
        String chooseField = reader.readLine();
        switch (chooseField) {
            case "1":
                System.out.println("Please enter new owner's name");
                String name = reader.readLine();
                owner.setName(name);
                System.out.println("Thank you, the owner's name is updated");
                break;
            case "2":
                System.out.println("Please enter new owner's telephone number");
                String number = reader.readLine();
                owner.setTelNumber(number);
                System.out.println("Thank you, the owner's telephone number is updated");
                break;
            case "3":
                System.out.println("Please enter new owner's email");
                String email = reader.readLine();
                owner.setEmail(email);
                System.out.println("Thank you, the owner's email is updated");
                break;
            default:
                System.out.println("Something went wrong... Try again please");
        }

    }

    private void deleteByName(BufferedReader reader) throws IOException {
        System.out.println("Are You sure that You want to delete owner? If yes, please enter owner's name");
        String name = reader.readLine();
        OwnerStorage.deleteOwner(name);
        System.out.println("Thank you, the owner is deleted");
    }

    private void stop() {
        System.exit(0);
    }

}
