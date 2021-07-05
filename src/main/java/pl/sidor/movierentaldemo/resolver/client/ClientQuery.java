package pl.sidor.movierentaldemo.resolver.client;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.movierentaldemo.entity.model.Client;
import pl.sidor.movierentaldemo.service.clientservice.ClientService;

@Component
@RequiredArgsConstructor
public class ClientQuery implements GraphQLQueryResolver {

    private final ClientService clientService;

    public Client findClientById(Long id) {
        return clientService.findClientById(id).orElse(new Client());
    }

    public Client findClientByNameAndLastName(String name, String lastName) {
        return clientService.findByNameAndLastName(name, lastName).orElse(new Client());
    }
}
