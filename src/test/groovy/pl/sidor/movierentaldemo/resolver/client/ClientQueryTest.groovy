package pl.sidor.movierentaldemo.resolver.client

import pl.sidor.movierentaldemo.service.clientservice.ClientServiceImpl
import pl.sidor.movierentaldemo.utils.ClientData
import spock.lang.Specification
import spock.lang.Unroll

class ClientQueryTest extends Specification {

    ClientServiceImpl clientService = Mock(ClientServiceImpl.class)
    ClientQuery sut = [clientService]

    @Unroll
    def "should find Client by ID"() {
        given:
        Long id = 1L

        when:
        clientService.findClientById(id) >> clients
        def client = sut.findClientById(id)

        then:
        client == expectedResult

        where:
        clients                             | expectedResult
        Optional.of(ClientData.getClient()) | ClientData.getClient()
    }

    @Unroll
    def "should find Client by name and lastName"() {
        given:
        String name="Jan"
        String lastName="Nowak"

        when:
        clientService.findByNameAndLastName(name, lastName) >> clients
        def client = sut.findClientByNameAndLastName(name, lastName)

        then:
        client == expectedResult

        where:
        clients                             | expectedResult
        Optional.of(ClientData.getClient()) | ClientData.getClient()
    }
}
