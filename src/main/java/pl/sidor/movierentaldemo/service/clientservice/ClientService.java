package pl.sidor.movierentaldemo.service.clientservice;

import pl.sidor.movierentaldemo.entity.model.Client;

import java.util.Optional;

public interface ClientService {

    Client createClient(Client client);

    boolean deleteClient(Long id);

    Optional<Client> findClientById(Long id);

    Optional<Client> findByNameAndLastName(String name, String lastName);
}
