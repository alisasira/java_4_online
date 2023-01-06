package hw5.service;

import hw5.dao.CarDaoImpl;
import hw5.dao.ClientDaoImpl;
import hw5.entity.Car;
import hw5.entity.Client;

import java.util.List;

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
        return carDao.findById(id);
    }
    public List<Car> findAll(){
        return carDao.findAll();
    }
}

