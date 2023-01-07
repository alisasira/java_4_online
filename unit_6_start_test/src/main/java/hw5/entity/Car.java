package hw5.entity;

import java.util.HashSet;
import java.util.Set;

public class Car extends BaseEntity {
    private String carNumber;
    private String carModel;
    private Set<String> clientIdList = new HashSet<>();

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Set<String> getClientIdList() {
        return clientIdList;
    }

    public void setClientIdList(Set<String> clientIdList) {
        this.clientIdList = clientIdList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNumber='" + carNumber + '\'' +
                ", carModel='" + carModel + '\'' +
                ", id='" + getId() + '\'' +
                ", clientIdList=" + clientIdList +
                '}';
    }
}
