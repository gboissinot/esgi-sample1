package fr.gboissinot.sample1.infrastructure;

import fr.gboissinot.sample1.domain.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryClients implements Clients {

    @Override
    public Client findById(ClientId clientId) {
        Address clientAddress = AddressFactory.of("FRANCE", "PARIS", "LECLERC", "75000");
        Client client = Client.of(clientId, "BOISSINOT", "GREGORY", clientAddress);
        return client;
    }

    @Override
    public void add(Client client) {
        System.out.println("Stubbing client access");
    }
}
