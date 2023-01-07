package hw5.entity;

import java.util.HashSet;
import java.util.Set;

public class Client extends BaseEntity {
    private String firstName;
    private String lastName;
    private Set<String> carIdList = new HashSet<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCarIdList(Set<String> carIdList) {
        this.carIdList = carIdList;
    }

    public Set<String> getCarIdList() {
        return carIdList;
    }



    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "id='" + getId() + '\'' +
                ", carIdList=" + carIdList +
                '}';
    }
}
