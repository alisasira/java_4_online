package hw5.dao;

import hw5.db.DbStorage;
import hw5.entity.Client;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ClientDaoImpl implements ClientDao {
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
        dbStorage.deleteClientFromCarList(id);
    }

    @Override
    public Optional<Client> findById(String id) {
        return dbStorage.clientFindById(id);
    }

    @Override
    public List<Client> findAll() {
        return dbStorage.findAllClients();
    }

    @Override
    public void attach(String clientId, String carId) {
        dbStorage.attach(clientId, carId);
    }
}
