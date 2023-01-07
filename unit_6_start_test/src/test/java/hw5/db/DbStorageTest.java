package hw5.db;

import hw5.entity.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class DbStorageTest {

    @Test
    public void testClientUpdate() {
        DbStorage storage = DbStorage.getInstance();

        String id = storage.addClient(makeClient("Alex", "Test"));
        storage.updateClient(makeClient(id, "Alex", "Grey"));

        Optional<Client> client = storage.clientFindById(id);

        System.out.println(storage.clientFindById(id));

        if(client.isEmpty()) {
            Assertions.fail("Client not found");
        }
        Assertions.assertEquals("Grey", client.get().getLastName());
    }

    private Client makeClient(String firstName, String lastName) {
        return makeClient(null, firstName, lastName);
    }

    private Client makeClient(String id, String firstName, String lastName) {
        Client client = new Client();
        client.setId(id);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        return client;
    }

}
