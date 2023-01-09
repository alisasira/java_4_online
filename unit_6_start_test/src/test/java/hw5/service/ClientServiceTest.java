package hw5.service;

import hw5.entity.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientServiceTest {

    private ClientService clientService = new ClientService();

    private static final String DEFAULT_FIRST_NAME = "Default";
    private static final String DEFAULT_LAST_NAME = "Test";

    @Test
    public void testCreateSuccessful() {
        String id = clientService.create(makeClient(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME));
        Assertions.assertNotNull(id);
    }

    @Test
    public void testValidationFailed() {
        {
            String id = clientService.create(makeClient("123456", DEFAULT_LAST_NAME));
            Assertions.assertNull(id);
        }
        {
            String id = clientService.create(makeClient(DEFAULT_FIRST_NAME, "123456"));
            Assertions.assertNull(id);
        }
    }

    private Client makeClient(String firstName, String lastName) {
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        return client;
    }
}
