package hw.module1.entity;

import java.util.Arrays;

public class Car extends BaseEntity {

    private String carNumber;
    private String carModel;
    private String[] clientIdList = new String[10];

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

    public String[] getClientIdList() {
        return clientIdList;
    }

    public void setClientIdList(String[] clientIdList) {
        this.clientIdList = clientIdList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNumber='" + carNumber + '\'' +
                ", carModel='" + carModel + '\'' +
                ", clientIdList=" + Arrays.toString(clientIdList) +
                '}';
    }
}
