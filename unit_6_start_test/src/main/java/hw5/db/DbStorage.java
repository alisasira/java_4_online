package hw5.db;

import hw5.entity.Car;
import hw5.entity.Client;

import java.util.*;

public class DbStorage {
    private static Set<Client> clients = new HashSet<>();
    private static Set<Car> cars = new HashSet<>();
    private static DbStorage instance;

    private DbStorage() {
    }

    public static DbStorage getInstance() {
        if (instance == null) {
            instance = new DbStorage();
        }
        return instance;
    }

    private String generateClientId() {
        String id = UUID.randomUUID().toString();
        if (clients.stream().anyMatch(client -> client.getId().equals(id))) {
            return generateClientId();
        }
        return id;
    }

    public String addClient(Client client) {
        String id = generateClientId();
        client.setId(id);
        clients.add(client);
        return id;
    }

    private String generateCarId() {
        String id = UUID.randomUUID().toString();
        if (cars.stream().anyMatch(client -> client.getId().equals(id))) {
            return generateClientId();
        }
        return id;
    }

    public void addCar(Car car) {
        car.setId(generateClientId());
        cars.add(car);
    }

    public List<Client> findAllClients() {
        return new ArrayList<>(clients);
    }

    public List<Car> findAllCars() {
        return new ArrayList<>(cars);
    }

    public Optional<Client> getClient(String id) {
        return clients.
                stream().
                filter(client -> client.getId().equals(id)).
                findFirst();
    }

    public static Optional<Car> getCar(String id) {
        return cars.
                stream().
                filter(car -> car.getId().equals(id)).
                findFirst();
    }

    public void attach(String clientId, String carId) {
        attachClientToCar(clientId, carId);
        attachCarToClient(clientId, carId);
    }
    private void attachClientToCar(String clientId, String carId) {
        getCar(carId).ifPresent(it -> {
            Set<String> clients = it.getClientIdList();
          //  Set<String> clients = car.getClientIdList();
            clients.add(clientId);
        });
    }

    private void attachCarToClient(String clientId, String carId) {
        getClient(clientId).ifPresent(it -> {
            Set<String> cars = it.getCarIdList();
            cars.add(carId);
        });
    }

    public void updateClient(Client client) {
        clients.add(client);
    }

    public void updateCar(Car car) {
        cars.add(car);
    }

    public Optional<Client> clientFindById(String id) {
        return clients
                .stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    public Optional<Car> carFindById(String id) {
        return cars
                .stream()
                .filter(car -> car.getId().equals(id))
                .findFirst();
    }

    public static void deleteClient(String id) {

        clients.removeIf(client -> client.getId().equals(id));
    }

    public static void deleteCar(String id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

    public void deleteClientFromCarList(String id) {
        getCar(id).ifPresent(car -> {
            car.getClientIdList().removeIf(client -> id.equals(client));
        });
    }

    public void deleteCarFromClientList(String id) {
        getClient(id).ifPresent(client -> {
            client.getCarIdList().removeIf(car -> id.equals(car));
        });
    }
}
