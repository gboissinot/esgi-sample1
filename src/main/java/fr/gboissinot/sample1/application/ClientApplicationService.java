package fr.gboissinot.sample1.application;

import fr.gboissinot.kernel.java.annotation.ddd.DDD;
import fr.gboissinot.sample1.domain.model.Address;
import fr.gboissinot.sample1.domain.model.Client;
import fr.gboissinot.sample1.domain.model.ClientId;
import fr.gboissinot.sample1.domain.model.Clients;
import org.springframework.stereotype.Service;

/**
 * List all use cases
 */
@DDD.ApplicationService
@Service
public class ClientApplicationService {

    private final Clients clients;

    public ClientApplicationService(Clients clients) {
        this.clients = clients;
    }


    /**
     * USE CASE 0: Fetch a given client
     */
    public Client find(ClientId clientId) {
        return clients.findById(clientId);
    }

    /**
     * USE CASE 1: Create the client
     */
    public void createClient(Client client) {
        clients.add(client);
    }

    /**
     * USE CASE 2: Modify the address of an existing client
     */
    public void modifyClientAddress(Client client, Address newAddress) {
        client.modifyAddress(newAddress);
        clients.add(client);
    }

}
