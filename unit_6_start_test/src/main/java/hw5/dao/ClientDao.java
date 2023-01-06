package hw5.dao;

import hw5.entity.Client;

import java.util.List;

public interface ClientDao {
    void create(Client client);
    void update(Client client);
    void delete(String id);
    Client findById(String id);
    List<Client> findAll();
}
