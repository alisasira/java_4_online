package hw.module1.entity;

import java.util.Arrays;

public class Client extends BaseEntity {
    private String firstName;
    private String lastName;
    private String[] carIdList = new String[10];

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.matches(".*\\d.*")) {
            System.out.println("Incorrect information. First name can't contain numbers.");
        } else {
        this.firstName = firstName;
    }
}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.matches(".*\\d.*")) {
            System.out.println("Incorrect information. Last name can't contain numbers.");
        } else {
            this.lastName = lastName;
        }
    }

    public String[] getCarIdList() {
        return carIdList;
    }

    public void setCarIdList(String[] carIdList) {
        this.carIdList = carIdList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", carIdList=" + Arrays.toString(carIdList) +
                '}';
    }
}
