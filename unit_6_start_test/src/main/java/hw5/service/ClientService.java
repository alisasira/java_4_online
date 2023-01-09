package hw5.service;


import hw5.dao.ClientDaoImpl;
import hw5.entity.Client;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ClientService {

    private ClientDaoImpl clientDao = new ClientDaoImpl();

    public String create(Client client) {
        if(!validateFirstName(client.getFirstName()) || !validateLastName(client.getLastName())) {
            System.out.println("Incorrect information. Name can't contain numbers.");
            return null;
        }
        return clientDao.create(client);
    }

    public void update(Client client) {
        if(!validateFirstName(client.getFirstName()) || !validateLastName(client.getLastName())) {
            System.out.println("Incorrect information. First name can't contain numbers.");
            return;
        }
        clientDao.update(client);
    }

    public void delete(String id) {
        clientDao.delete(id);
    }

    public Client findById(String id) {
        Optional<Client> client = clientDao.findById(id);
        return client.orElse(null);
    }

    public List<Client> findAll() {
        return clientDao.findAll();
    }

    public void attach(String clientId, String carId) {
        if (clientId == null || carId == null) {
            System.out.println("This ID does not exist.");
        } else {
            clientDao.attach(clientId, carId);
            System.out.println("Attachment is successful.");
        }
    }

    private boolean validateFirstName(String firstName) {
        return firstName.matches("[A-Za-z]+");
    }

    private boolean validateLastName(String lastName){
        return lastName.matches("[A-Za-z]+");
    }
}
