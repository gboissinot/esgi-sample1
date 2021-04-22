package fr.gboissinot.sample1.domain.model;

import fr.gboissinot.sample1.application.ClientApplicationService;
import fr.gboissinot.sample1.infrastructure.MySQLClients;

public class TestClient {

    public static void main(String[] args) {

//        ClientId clientId = ClientId.of(5);
//        Client client = Client.of(clientId, "BOISSINOT", "GREGORY");
//        System.out.println(client);
//        System.out.println("Client has filled an address : " + client.address().isAddress());
//
//
//        Address clientAddress = AddressFactory.of("FRANCE", "PARIS", "LECLERC", "75000");
//        client.modifyAddress(clientAddress);
//        System.out.println("Client has filled an address : " + client.address().isAddress());
//        System.out.println(client);

        //-- USE CASE
        ClientApplicationService clientApplicationService = new ClientApplicationService(new MySQLClients());
        ClientId clientId = ClientId.of(5);
        Address clientAddress = AddressFactory.of("FRANCE", "PARIS", "LECLERC", "75000");
        Client client = Client.of(clientId, "BOISSINOT", "GREGORY", clientAddress);
        clientApplicationService.createClient(client);


    }
}
