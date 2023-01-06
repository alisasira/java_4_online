package hw5.service;


import hw5.dao.ClientDaoImpl;
import hw5.entity.Client;

import java.util.List;

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
        return clientDao.findById(id);
    }
    public List<Client> findAll(){
        return clientDao.findAll();
    }
}
