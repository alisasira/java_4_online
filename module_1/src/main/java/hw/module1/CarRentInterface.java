package hw.module1;

import hw.module1.db.DbStorage;
import hw.module1.entity.Car;
import hw.module1.entity.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarRentInterface {
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to car rent service!");
        System.out.println("Please select your option:");
        String input;
        menu();
        while ((input = reader.readLine()) != null) {
            crud(reader, input);
            menu();
        }
    }
    private void menu(){
        System.out.println("\nIf You want to create a new client, please enter 1");
        System.out.println("If You want to create a new car, please enter 2");
        System.out.println("If You want to find a client, please enter 3");
        System.out.println("If You want to find a car, please enter 4");
        System.out.println("If You want to find all clients, please enter 5");
        System.out.println("If You want to find all cars, please enter 6");
        System.out.println("If You want to update a client, please enter 7");
        System.out.println("If You want to update a car, please enter 8");
        System.out.println("If You want to attach a client to the car, please enter 9");
        System.out.println("If You want to attach a car to the client, please enter 10");
        System.out.println("If You want to delete a client, please enter 11");
        System.out.println("If You want to delete a car, please enter 12");
        System.out.println("If You want to close application, please enter 13");
    }

    private void crud(BufferedReader reader, String input) throws IOException {
        switch (input){
            case "1":
               createClient(reader);
                break;
            case "2":
              createCar(reader);
                break;
            case "3":
                findClient(reader);
                break;
            case "4":
                findCar(reader);
                break;
            case "5":
                findAllClients();
                break;
            case "6":
                findAllCars();
                break;
            case "7":
                updateClient(reader);
                break;
            case "8":
                updateCar(reader);
                break;
            case "9":
                attachClientToCar(reader);
                break;
            case "10":
                attachCarToClient(reader);
                break;
            case "11":
                deleteClient(reader);
                break;
            case "12":
                deleteCar(reader);
                break;
            case "13":
                stop();
                break;
            case "":
                break;
            default:
                System.out.println("Something went wrong... Try again please");
        }
    }
    private void createClient(BufferedReader reader) throws IOException {
        System.out.println("Let's create a new client.");
        System.out.println("Please enter client's first name:");
        String firstName = reader.readLine();
        System.out.println("Please enter client's last name:");
        String lastName = reader.readLine();
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        DbStorage.addClient(client);
        System.out.println("New client is created. His/her ID is " + client.getId());
    }
    private void createCar(BufferedReader reader) throws IOException {
        System.out.println("Let's create a new car.");
        System.out.println("Please enter car's model:");
        String carModel = reader.readLine();
        System.out.println("Please enter car's number:");
        String carNumber = reader.readLine();
        Car car = new Car();
        car.setCarModel(carModel);
        car.setCarNumber(carNumber);
        DbStorage.addCar(car);
        System.out.println("New car is created. It's ID is "+ car.getId());
    }
    private void findClient(BufferedReader reader) throws IOException {
        System.out.println("To find the client please enter client's ID:");
        String clientId = reader.readLine();
        Client client = DbStorage.getClient(clientId);
        if(client == null){
            System.out.println("This client does not exist.");
        } else {
            System.out.println(client);
        }
    }
    private void findCar(BufferedReader reader) throws IOException {
        System.out.println("To find the car please enter car's ID:");
        String carId = reader.readLine();
        Car car = DbStorage.getCar(carId);
        if(car == null){
            System.out.println("This car does not exist.");
        } else {
            System.out.println(car);
        }
    }
    private void findAllClients(){
        System.out.println("Clients list:");
        Client[] clients = DbStorage.findAllClients();
        for(int i = 0; i < clients.length; i++) {
            if(clients[i] != null) {
                System.out.println(clients[i]);
            }
        }
    }
    private void findAllCars(){
        System.out.println("Cars list:");
        Car[] cars = DbStorage.findAllCars();
        for(int i = 0; i < cars.length; i++) {
            if(cars[i] != null) {
                System.out.println(cars[i]);
            }
        }
    }
    private void updateClient(BufferedReader reader) throws IOException {
        System.out.println("Let's update client's information. To start, please enter client's ID:");
        String clientId = reader.readLine();
        Client client = DbStorage.getClient(clientId);
        if(client == null){
            System.out.println("This client does not exist.");
        } else {
            System.out.println("Please enter client's first name:");
            String firstName = reader.readLine();
            client.setFirstName(firstName);
            System.out.println("Please enter client's last name:");
            String lastName = reader.readLine();
            client.setLastName(lastName);
            System.out.println("Thank you, the client's information is updated.");
        }
    }
    private void updateCar(BufferedReader reader) throws IOException {
        System.out.println("Let's update car's information. To start, please enter car's ID:");
        String carId = reader.readLine();
        Car car = DbStorage.getCar(carId);
        if(car == null){
            System.out.println("This car does not exist.");
        } else {
            System.out.println("Please enter car's number:");
            String carNumber = reader.readLine();
            car.setCarNumber(carNumber);
            System.out.println("Please enter car's model:");
            String carModel = reader.readLine();
            car.setCarModel(carModel);
            System.out.println("Thank you, the car's information is updated.");
        }
    }
    private void attachClientToCar(BufferedReader reader) throws IOException {
        System.out.println("Let's attach the client to car. To start, please enter client's ID:");
        String clientId = reader.readLine();
        System.out.println("Then please enter car's ID:");
        String carId = reader.readLine();
        if (clientId == null || carId == null) {
            System.out.println("This ID does not exist.");
        } else {
            DbStorage.attach(clientId, carId);
            System.out.println("Attachment is successful.");
        }
    }
    private void attachCarToClient(BufferedReader reader) throws IOException {
        System.out.println("Let's attach the car to client. To start, please enter car's ID:");
        String carId = reader.readLine();
        System.out.println("Then please enter client's ID:");
        String clientId = reader.readLine();
        if (clientId == null || carId == null) {
            System.out.println("This ID does not exist.");
        } else {
            DbStorage.attach(clientId, carId);
            System.out.println("Attachment is successful.");
        }
    }
    private void deleteClient(BufferedReader reader) throws IOException {
        System.out.println("To delete the client please enter his ID:");
        String clientId = reader.readLine();
        DbStorage.deleteClient(clientId);
        DbStorage.deleteClientFromCarList(clientId);
        System.out.println("The client is deleted.");
    }
    private void deleteCar(BufferedReader reader) throws IOException {
        System.out.println("To delete the car please enter it's ID:");
        String carId = reader.readLine();
        DbStorage.deleteCar(carId);
        DbStorage.deleteCarFromClientList(carId);
        System.out.println("The car is deleted.");
    }
    private void stop() {
        System.exit(0);
    }
}
