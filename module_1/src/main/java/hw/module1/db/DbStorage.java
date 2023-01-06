package hw.module1.db;

import hw.module1.entity.Car;
import hw.module1.entity.Client;
import java.util.Arrays;
import java.util.UUID;

public class DbStorage {
    private static int capacity = 10;
    private static Client[] clients = new Client[capacity];
    private static Car[] cars = new Car[capacity];
    private static int index = 0;

    private DbStorage() {}


    private static String generateClientId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                if (clients[i].getId().equals(id)) {
                    return generateClientId();
                }
            }
        }
        return id;
    }

    public static void addClient(Client client) {
        client.setId(generateClientId());
        if (index == clients.length) {
            Client[] temp = Arrays.copyOf(clients, clients.length + capacity);
            clients = temp;
        }
        clients[index] = client;
        index++;
    }

    private static String generateCarId() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                if (cars[i].getId().equals(id)) {
                    return generateClientId();
                }
            }
        }
        return id;
    }

    public static void addCar(Car car) {
        car.setId(generateCarId());
        if (index == cars.length) {
            Car[] temp = Arrays.copyOf(cars, cars.length + capacity);
            cars = temp;
        }
        cars[index] = car;
        index++;
    }

    public static Client[] findAllClients() {
        return clients;
    }

    public static Car[] findAllCars() {
        return cars;
    }

    public static Client getClient(String id) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                if (clients[i].getId().equals(id)) {
                    return clients[i];
                }
            }
        }
        return null;
    }

    public static void attach(String clientId, String carId) {
        attachClientToCar(clientId, carId);
        attachCarToClient(clientId, carId);
    }

    private static void attachClientToCar(String clientId, String carId) {
        Car car = getCar(carId);
        String[] clients = car.getClientIdList();
        clients = addUniqueElementToArray(clients, clientId);
        car.setClientIdList(clients);
    }

    private static void attachCarToClient(String clientId, String carId) {
        Client client = getClient(clientId);
        String[] cars = client.getCarIdList();
        cars = addUniqueElementToArray(cars, carId);
        client.setCarIdList(cars);
    }

    private static String[] addUniqueElementToArray(String[] array, String element) {
        int emptyIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].equals(element)) {
                    return array;
                }
            } else if(emptyIndex == -1){
                emptyIndex = i;
            }
        }

        if(emptyIndex == -1) {
                String[] temp = Arrays.copyOf(array, array.length + capacity);
                array = temp;
            }
        array[emptyIndex] = element;
        return array;
    }

    public static Car getCar(String id) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                if (cars[i].getId().equals(id)) {
                    return cars[i];
                }
            }
        }
        return null;
    }

    public static void deleteClient(String id) {
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null) {
                if (clients[i].getId().equals(id)) {
                    clients[i] = null;
                }
            }
        }
    }

    public static void deleteClientFromCarList(String id) {
        Client client = getClient(id);
        if(client == null) {
            System.out.println("Client " + id + " was not found");
            return;
        }
        String[] deleteList = client.getCarIdList();
        for (int i = 0; i < deleteList.length; i++) {
            if (deleteList[i] != null) {
                if (deleteList[i].equals(id)) {
                    deleteList[i] = null;
                }
            }
        }
    }

    public static void deleteCar(String id) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                if (cars[i].getId().equals(id)) {
                    cars[i] = null;
                }
            }
        }
    }

    public static void deleteCarFromClientList(String id) {
        Car car = getCar(id);
        if(car == null) {
            System.out.println("Car " + id + " was not found");
            return;
        }
        String[] deleteList = car.getClientIdList();
        for (int i = 0; i < deleteList.length; i++) {
            if (deleteList[i] != null) {
                if (deleteList[i].equals(id)) {
                    deleteList[i] = null;
                }
            }
        }
    }
}
