package pl.sidor.movierentaldemo.service.clientservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sidor.movierentaldemo.entity.model.Client;
import pl.sidor.movierentaldemo.repository.ClientRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> findByNameAndLastName(String name, String lastName) {
        return clientRepository.findByNameAndLastName(name, lastName);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public boolean deleteClient(Long id) {
        if (findClientById(id).isPresent()) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
