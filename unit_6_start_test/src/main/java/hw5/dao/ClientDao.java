package hw5.dao;

import hw5.entity.Client;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ClientDao {

    String create(Client client);

    void update(Client client);

    void delete(String id);

    Optional<Client> findById(String id);

    List<Client> findAll();

    void attach(String clientId, String carId);
}
