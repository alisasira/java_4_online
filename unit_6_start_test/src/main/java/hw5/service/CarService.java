package hw5.service;

import hw5.dao.CarDaoImpl;
import hw5.dao.ClientDaoImpl;
import hw5.entity.Car;
import hw5.entity.Client;

import java.util.List;
import java.util.Optional;

public class CarService {
    private CarDaoImpl carDao = new CarDaoImpl();

    public void create(Car car){
        carDao.create(car);
    }
    public void update(Car car){
        carDao.update(car);
    }
    public void delete(String id){
        carDao.delete(id);
    }
    public Car findById(String id){
        Optional<Car> car = carDao.findById(id);
        return car.orElse(null);
    }
    public List<Car> findAll(){
        return carDao.findAll();
    }

    public void attach(String clientId, String carId) {
        if (clientId == null || carId == null) {
            System.out.println("This ID does not exist.");
        } else {
            carDao.attach(clientId, carId);
            System.out.println("Attachment is successful.");
        }
    }

}

