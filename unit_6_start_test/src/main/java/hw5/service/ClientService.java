package hw5.service;


import hw5.dao.ClientDaoImpl;
import hw5.entity.Client;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ClientService {
    private ClientDaoImpl clientDao = new ClientDaoImpl();

    public void create(Client client){
        clientDao.create(client);
    }
    public void update(Client client){
        clientDao.update(client);
    }
    public void delete(String id){
        clientDao.delete(id);
    }
    public Client findById(String id){
        Optional<Client> client = clientDao.findById(id);
        return client.orElse(null);
    }
    public List<Client> findAll(){
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

}
