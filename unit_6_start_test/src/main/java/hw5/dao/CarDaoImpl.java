package hw5.dao;

import hw5.db.DbStorage;
import hw5.entity.Car;

import java.util.List;

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
    }

    @Override
    public Car findById(String id) {
        return dbStorage.carFindById(id).get();
    }

    @Override
    public List<Car> findAll() {
        return dbStorage.carFindAll();
    }
}
