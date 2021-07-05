package pl.sidor.movierentaldemo.resolver.client;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sidor.movierentaldemo.entity.model.Client;
import pl.sidor.movierentaldemo.service.clientservice.ClientService;

@Component
@RequiredArgsConstructor
public class ClientMutation implements GraphQLMutationResolver {

    private final ClientService clientService;

    public Client createClient(Client client) {
        return clientService.createClient(client);
    }

    public boolean deleteClient(Long id) {
        return clientService.deleteClient(id);
    }
}
