package fr.gboissinot.sample1.infrastructure;

import fr.gboissinot.sample1.domain.model.Client;

import java.util.function.Function;

public class ClientDataModelAdapter implements Function<Client, ClientDataModel> {

    private static ClientDataModelAdapter INSTANCE = new ClientDataModelAdapter();

    public static ClientDataModelAdapter getInstance() {
        return INSTANCE;
    }

    @Override
    public ClientDataModel apply(Client client) {
        ClientDataModel dataModel = new ClientDataModel();
        dataModel.setId(client.id().value());
        dataModel.setLastname(client.lastname());

        //..

        dataModel.setCity(client.address().city());

        //...

        return dataModel;
    }
}
