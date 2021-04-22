package fr.gboissinot.sample1.infrastructure;

import fr.gboissinot.sample1.domain.model.Client;
import fr.gboissinot.sample1.domain.model.ClientId;
import fr.gboissinot.sample1.domain.model.Clients;

public class MySQLClients implements Clients {

    @Override
    public Client findById(ClientId clientId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(Client client) {
        System.out.println("Saving client into MySQL....");

        ClientDataModel clientDataModel = ClientDataModelAdapter.getInstance().apply(client);

        //Use the clientModel for inserting values
    }
}
