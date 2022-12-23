package hw.unit4;

import java.util.Arrays;

public class OwnerStorage {

    private static int capacity = 10;
    private static Owner[] owners = new Owner[capacity];
    private static int index = 0;

    private OwnerStorage() {
    }

    public static Owner[] getOwner() {
        return owners;
    }

    public static void addOwner(Owner owner) {
        if (index == owners.length) {
            Owner[] temp = Arrays.copyOf(owners, owners.length + capacity);
            owners = temp;
        }
        owners[index] = owner;
        index++;
    }

    public static void deleteOwner(String name) {
        for (int i = 0; i < owners.length; i++) {
            if (owners[i] != null) {
                if (owners[i].getName().equals(name)) {
                    owners[i] = null;
                }
            }
        }
    }

    public static Owner getOwner(String aptNumber) {
        Owner owner = null;
        for (int i = 0; i < owners.length; i++) {
            if (owners[i] != null) {
                if (owners[i].getAptNumber().equals(aptNumber)) {
                    owner = owners[i];
                }
            }
        }
        return owner;
    }
}
