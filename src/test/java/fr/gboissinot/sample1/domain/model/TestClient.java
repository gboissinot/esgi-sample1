package fr.gboissinot.sample1.domain.model;

public class TestClient {

    public static void main(String[] args) {

        ClientId clientId = ClientId.of(5);
        Client client = Client.of(clientId, "BOISSINOT", "GREGORY");
        System.out.println(client);
        System.out.println("Client has filled an address : " + client.address().isAddress());


        Address clientAddress = AddressFactory.of("FRANCE", "PARIS", "LECLERC", "75000");

        client.modifyAddress(clientAddress);
        System.out.println("Client has filled an address : " + client.address().isAddress());

        System.out.println(client);


    }
}
