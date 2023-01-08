package hw5.controller;

import hw5.db.DbStorage;
import hw5.entity.Car;
import hw5.entity.Client;
import hw5.service.CarService;
import hw5.service.ClientService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

public class ClientController {
    private ClientService clientService = new ClientService();
    private CarService carService = new CarService();

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
        clientService.create(client);
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
        carService.create(car);
        System.out.println("New car is created. It's ID is "+ car.getId());
    }
    private void findClient(BufferedReader reader) throws IOException {
        System.out.println("To find the client please enter client's ID:");
        String clientId = reader.readLine();
       Client client = clientService.findById(clientId);
        if(client == null){
            System.out.println("This client does not exist.");
        } else {
            System.out.println(client);
        }
    }
    private void findCar(BufferedReader reader) throws IOException {
        System.out.println("To find the car please enter car's ID:");
        String carId = reader.readLine();
        Car car = carService.findById(carId);
        if(car == null){
            System.out.println("This car does not exist.");
        } else {
            System.out.println(car);
        }
    }
    private void findAllClients(){
        System.out.println("Clients list:");
        List<Client> clients = clientService.findAll();
        System.out.println("clients = " + clients);
    }
    private void findAllCars(){
        System.out.println("Cars list:");
        List<Car> cars = carService.findAll();
        System.out.println("cars = " + cars);
    }
    private void updateClient(BufferedReader reader) throws IOException {
        System.out.println("Let's update client's information. To start, please enter client's ID:");
        String clientId = reader.readLine();
        Optional<Client> client = DbStorage.getInstance().getClient(clientId);
        if(client.isEmpty()){
            System.out.println("This client does not exist.");
        } else {
            System.out.println("Please enter client's first name:");
            String firstName = reader.readLine();
            client.get().setFirstName(firstName);
            System.out.println("Please enter client's last name:");
            String lastName = reader.readLine();
            client.get().setLastName(lastName);
            System.out.println("Thank you, the client's information is updated.");
        }
    }
    private void updateCar(BufferedReader reader) throws IOException {
        System.out.println("Let's update car's information. To start, please enter car's ID:");
        String carId = reader.readLine();
        Optional<Car> car = DbStorage.getInstance().getCar(carId);
        if(car.isEmpty()){
            System.out.println("This car does not exist.");
        } else {
            System.out.println("Please enter car's number:");
            String carNumber = reader.readLine();
            car.get().setCarNumber(carNumber);
            System.out.println("Please enter car's model:");
            String carModel = reader.readLine();
            car.get().setCarModel(carModel);
            System.out.println("Thank you, the car's information is updated.");
        }
    }
    private void attachClientToCar(BufferedReader reader) throws IOException {
        System.out.println("Let's attach the client to car. To start, please enter client's ID:");
        String clientId = reader.readLine();
        System.out.println("Then please enter car's ID:");
        String carId = reader.readLine();
        clientService.attach(clientId, carId);
    }
    private void attachCarToClient(BufferedReader reader) throws IOException {
        System.out.println("Let's attach the car to client. To start, please enter car's ID:");
        String carId = reader.readLine();
        System.out.println("Then please enter client's ID:");
        String clientId = reader.readLine();
        carService.attach(clientId, carId);
    }
    private void deleteClient(BufferedReader reader) throws IOException {
        System.out.println("To delete the client please enter his ID:");
        String clientId = reader.readLine();
        clientService.delete(clientId);
        System.out.println("The client is deleted.");
    }
    private void deleteCar(BufferedReader reader) throws IOException {
        System.out.println("To delete the car please enter it's ID:");
        String carId = reader.readLine();
        carService.delete(carId);
        System.out.println("The car is deleted.");
    }

    private void stop() {
        System.exit(0);
    }
}
