package hw5.dao;

import hw5.entity.Car;
import hw5.entity.Client;

import java.util.List;

public interface CarDao {
    void create(Car car);
    void update(Car car);
    void delete(String id);
    Car findById(String id);
    List<Car> findAll();
}
