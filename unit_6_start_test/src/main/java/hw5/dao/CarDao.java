package hw5.dao;

import hw5.entity.Car;
import hw5.entity.Client;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CarDao {
    void create(Car car);

    void update(Car car);

    void delete(String id);

    Optional<Car> findById(String id);

    List<Car> findAll();

    void attach(String clientId, String carId);
}
