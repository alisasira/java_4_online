package hw5.db;

import hw5.entity.Car;
import hw5.entity.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class DbStorageTest {

    private final DbStorage storage = DbStorage.getInstance();

    private static final String DEFAULT_FIRST_NAME = "Default";
    private static final String DEFAULT_LAST_NAME = "Test";

    private static final String DEFAULT_NUMBER = "AA3456BB";
    private static final String DEFAULT_MODEL = "Tesla";

    private String defaultClientId;
    private String defaultCartId;

    @BeforeEach
    public void setup() {
        storage.clean();

        defaultClientId = storage.addClient(makeClient(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME));
        defaultCartId = storage.addCar(makeCar(DEFAULT_NUMBER, DEFAULT_MODEL));
    }

    @Test
    public void testAddClient() {
        String FIRST_NAME = "Alex";
        String LAST_NAME = "Test";

        String id = storage.addClient(makeClient(FIRST_NAME, LAST_NAME));

        Optional<Client> result = storage.findAllClients().stream().filter(it -> it.getId().equals(id)).findFirst();

        Assertions.assertTrue(result.isPresent());
        {
            Client client = result.get();
            Assertions.assertEquals(FIRST_NAME, client.getFirstName());
            Assertions.assertEquals(LAST_NAME, client.getLastName());
        }
    }

    @Test
    public void testAddCar() {
        String CAR_NUMBER = "AA1234BB";
        String CAR_MODEL = "Tesla";
        String id = storage.addCar(makeCar(CAR_NUMBER, CAR_MODEL));
        Optional<Car> result = storage.findAllCars().stream().filter(it -> it.getId().equals(id)).findFirst();
        Assertions.assertTrue(result.isPresent());
        {
            Car car = result.get();
            Assertions.assertEquals(CAR_NUMBER, car.getCarNumber());
            Assertions.assertEquals(CAR_MODEL, car.getCarModel());
        }
    }

    @Test
    public void findAllClients() {
        List<Client> result = storage.findAllClients();
        Optional<Client> item = result.stream().filter(it -> it.getId().equals(defaultClientId)).findFirst();

        Assertions.assertTrue(item.isPresent());
        Assertions.assertEquals(DEFAULT_FIRST_NAME, item.get().getFirstName());
    }

    @Test
    public void findAllCars() {
        List<Car> result = storage.findAllCars();
        Optional<Car> item = result.stream().filter(it -> it.getId().equals(defaultCartId)).findFirst();

        Assertions.assertTrue(item.isPresent());
        Assertions.assertEquals(DEFAULT_MODEL, item.get().getCarModel());
    }

    @Test
    public void getClient() {
        Optional<Client> result = storage.getClient(defaultClientId);
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    public void getCar() {
        Optional<Car> result = storage.getCar(defaultCartId);
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    public void attach() {
        storage.attach(defaultClientId, defaultCartId);

        Optional<Client> client = storage.getClient(defaultClientId);
        Assertions.assertTrue(client.isPresent());

        Optional<Car> car = storage.getCar(defaultCartId);
        Assertions.assertTrue(car.isPresent());

        Assertions.assertTrue(car.get().getClientIdList().contains(defaultClientId));
        Assertions.assertTrue(client.get().getCarIdList().contains(defaultCartId));
    }

    @Test
    public void testUpdateClient() {
        storage.updateClient(makeClient(defaultClientId, DEFAULT_FIRST_NAME, "Fire"));

        Optional<Client> client = storage.getClient(defaultClientId);
        Assertions.assertTrue(client.isPresent());

        Assertions.assertEquals("Fire", client.get().getLastName());
    }

    @Test
    public void testUpdateCar() {
        storage.updateCar(makeCar(defaultCartId, DEFAULT_NUMBER, "BMW"));

        Optional<Car> car = storage.getCar(defaultCartId);
        Assertions.assertTrue(car.isPresent());

        Assertions.assertEquals("BMW", car.get().getCarModel());
    }

    @Test
    public void deleteClient() {
        storage.deleteClient(defaultClientId);
        storage.deleteClientFromCarList(defaultClientId);

        Optional<Client> client = storage.getClient(defaultClientId);
        Assertions.assertFalse(client.isPresent());

        Optional<Car> car = storage.getCar(defaultCartId);
        Assertions.assertTrue(car.isPresent());
        Assertions.assertTrue(car.get().getClientIdList().isEmpty());
    }

    @Test
    public void deleteCar() {
        storage.deleteCar(defaultCartId);
        storage.deleteCarFromClientList(defaultCartId);

        Optional<Car> car = storage.getCar(defaultCartId);
        Assertions.assertFalse(car.isPresent());

        Optional<Client> client = storage.getClient(defaultClientId);
        Assertions.assertTrue(client.isPresent());
        Assertions.assertTrue(client.get().getCarIdList().isEmpty());
    }

    private Client makeClient(String firstName, String lastName) {
        return makeClient(null, firstName, lastName);
    }

    private Client makeClient(String id, String firstName, String lastName) {
        Client client = new Client();
        client.setId(id);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        return client;
    }

    private Car makeCar(String id, String carNumber, String carModel) {
        Car car = new Car();
        car.setId(id);
        car.setCarNumber(carNumber);
        car.setCarModel(carModel);
        return car;
    }

    private Car makeCar(String carNumber, String carModel) {
        return makeCar(null, carNumber, carModel);
    }
}
