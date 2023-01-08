package hw5.dao;

import hw5.db.DbStorage;
import hw5.entity.Car;

import java.util.List;
import java.util.Optional;

public class CarDaoImpl implements CarDao {
    DbStorage dbStorage = DbStorage.getInstance();

    @Override
    public void create(Car car) {
        dbStorage.addCar(car);
    }

    @Override
    public void update(Car car) {
        dbStorage.updateCar(car);
    }

    @Override
    public void delete(String id) {
        dbStorage.deleteCar(id);
        dbStorage.deleteCarFromClientList(id);
    }

    @Override
    public Optional<Car> findById(String id) {
        return dbStorage.getCar(id);
    }

    @Override
    public List<Car> findAll() {
        return dbStorage.findAllCars();
    }

    @Override
    public void attach(String clientId, String carId) {
        dbStorage.attach(clientId, carId);
    }
}
