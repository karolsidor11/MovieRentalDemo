package pl.sidor.movierentaldemo.resolver.client

import pl.sidor.movierentaldemo.entity.model.Client
import pl.sidor.movierentaldemo.service.clientservice.ClientServiceImpl
import pl.sidor.movierentaldemo.utils.ClientData
import spock.lang.Specification
import spock.lang.Unroll

class ClientMutationTest extends Specification {

    ClientServiceImpl clientService = Mock(ClientServiceImpl.class)
    ClientMutation sut = [clientService]

    def "should create Client"() {
        given:
        Client client = ClientData.getClient()

        when:
        clientService.createClient(client) >> client
        def currentClient = sut.createClient(client)

        then:
        noExceptionThrown()
        currentClient != null
        currentClient.name == "Karol"
        currentClient.lastName == "Sidor"
    }

    @Unroll
    def "should delete Client by ID"() {
        given:
        Long id = 1L

        when:
        clientService.deleteClient(id) >> clients
        def result = sut.deleteClient(id)

        then:
        result == expectedResult

        where:
        clients                             | expectedResult
        Optional.empty()                    | false
        Optional.of(ClientData.getClient()) | true
    }
}
