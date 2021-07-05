package pl.sidor.movierentaldemo.service.clientservice

import pl.sidor.movierentaldemo.entity.model.Client
import pl.sidor.movierentaldemo.repository.ClientRepository
import pl.sidor.movierentaldemo.utils.ClientData
import spock.lang.Specification
import spock.lang.Unroll

class ClientServiceImplTest extends Specification {

    ClientRepository clientRepository = Mock(ClientRepository.class)
    ClientServiceImpl clientService = [clientRepository]

    @Unroll
    def "should find Client by ID"() {
        given:
        Long id = 1L

        when:
        clientRepository.findById(id) >> clients
        def client = clientService.findClientById(id)

        then:
        client.isPresent() == expectedResult

        where:
        clients                             | expectedResult
        Optional.empty()                    | false
        Optional.of(ClientData.getClient()) | true

    }

    @Unroll
    def "should find Client by name and lastName"() {
        given:
        String name = "Jan"
        String lastName = "Nowak"

        when:
        clientRepository.findByNameAndLastName(name, lastName) >> clients
        def client = clientService.findByNameAndLastName(name, lastName);

        then:
        client.isPresent() == expectedResult

        where:
        clients                             | expectedResult
        Optional.empty()                    | false
        Optional.of(ClientData.getClient()) | true
    }

    def "should create Client"() {
        given:
        Client client = ClientData.getClient()

        when:
        clientRepository.save(client) >> client
        def currentClient = clientService.createClient(client)

        then:
        noExceptionThrown()
        currentClient != null
        currentClient.name == "Karol"
        currentClient.lastName == "Sidor"
    }

    @Unroll
    def "should delete Client byID"() {
        given:
        Long id = 1L

        when:
        clientRepository.findById(id) >> result
        def currentResult = clientService.deleteClient(id)

        then:
        currentResult == expectedResult

        where:
        result                              | expectedResult
        Optional.empty()                    | false
        Optional.of(ClientData.getClient()) | true

    }
}
