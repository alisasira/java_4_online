package hw5.dao;

import hw5.db.DbStorage;
import hw5.entity.Client;

import java.util.List;

public class ClientDaoImpl implements ClientDao{
    DbStorage dbStorage = DbStorage.getInstance();

    @Override
    public void create(Client client) {
        dbStorage.addClient(client);
    }

    @Override
    public void update(Client client) {
        dbStorage.updateClient(client);
    }

    @Override
    public void delete(String id) {
        dbStorage.deleteClient(id);
    }

    @Override
    public Client findById(String id) {
        return dbStorage.clientFindById(id).get();
    }

    @Override
    public List<Client> findAll() {
        return dbStorage.clientFindAll();
    }
}
