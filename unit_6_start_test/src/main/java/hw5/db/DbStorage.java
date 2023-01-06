package hw5.db;

import hw5.entity.Car;
import hw5.entity.Client;

import java.util.*;

public class DbStorage {
    private static List<Client> clients = new ArrayList<>();
    private static List<Car> cars = new ArrayList<>();
    private static DbStorage instance;

    private DbStorage(){}

    public static DbStorage getInstance(){
        if (instance == null) {
            instance = new DbStorage();
        }
        return instance;
    }

    private static String generateClientId() {
        String id = UUID.randomUUID().toString();
        if (clients.stream().anyMatch(client -> client.getId().equals(id))) {
            return generateClientId();
        }
        return id;
    }
    public static void addClient(Client client){
        client.setId(generateClientId());
        clients.add(client);
    }
    private static String generateCarId(){
        String id = UUID.randomUUID().toString();
        if (cars.stream().anyMatch(client -> client.getId().equals(id))) {
            return generateClientId();
        }
        return id;
    }
    public static void addCar(Car car){
        car.setId(generateClientId());
        cars.add(car);
    }
    public static List<Client> findAllClients() {
        return clients;
    }

    public static List<Car> findAllCars() {
        return cars;
    }

    public static Optional<Client> getClient(String id){
        return clients.
                stream().
                filter(client -> client.getId().equals(id)).
                findFirst();
    }
    public static Optional<Car> getCar(String id){
        return cars.
                stream().
                filter(car -> car.getId().equals(id)).
                findFirst();
    }
    public static void attachClientToCar(String clientId, String carId){
        getCar(carId).ifPresent(car -> {
            Set<String> clients = car.getClientIdList();
            clients.add(clientId);
        });
    }
    public static void attachCarToClient(String clientId, String carId){
        getClient(clientId).ifPresent(it -> {
            Set<String> cars = it.getCarIdList();
            cars.add(carId);
        });
    }

    public void updateClient(Client client) {
        Optional<Client> optionalClient = clientFindById(client.getId());
        if (optionalClient.isPresent()) {
            Client current = optionalClient.get();
            current = client;
        }
    }
        public void updateCar(Car car){
            Optional<Car> optionalCar = carFindById(car.getId());
            if(optionalCar.isPresent()){
                Car current = optionalCar.get();
                current = car;
            }

    }
    public Optional<Client> clientFindById(String id){
        return clients
                .stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }
        public Optional<Car> carFindById(String id){
            return cars
                    .stream()
                    .filter(car -> car.getId().equals(id))
                    .findFirst();
        }

 public static void deleteClient(String id){
     clients.removeIf(client -> client.getId().equals(id));
 }
    public static void deleteCar(String id){
     cars.removeIf(car -> car.getId().equals(id));
    }
    public static void deleteClientFromCarList(String id){
        getCar(id).ifPresent(car -> {
            car.getClientIdList().removeIf(client -> id.equals(client));
        });
    }
    public static void deleteCarFromClientList(String id){
        getClient(id).ifPresent(client -> {
            client.getCarIdList().removeIf(car -> id.equals(car));
        });
    }
}
