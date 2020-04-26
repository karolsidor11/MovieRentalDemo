package pl.sidor.movierentaldemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sidor.movierentaldemo.entity.model.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    Optional<Client> findByNameAndLastName(String name, String lastName);
}
