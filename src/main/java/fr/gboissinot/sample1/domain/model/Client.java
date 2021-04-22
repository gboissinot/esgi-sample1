package fr.gboissinot.sample1.domain.model;

import fr.gboissinot.kernel.java.annotation.Pattern;
import fr.gboissinot.kernel.java.annotation.ddd.DDD;

import java.util.Objects;

@SuppressWarnings("unused")
@DDD.Entity
public class Client {

    private final ClientId clientId;
    private final String lastname;
    private final String firstname;
    private Address address;

    private Client(ClientId clientId, String lastname, String firstname, Address address) {
        this.clientId = clientId;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }

    @Pattern.StaticFactoryMethod
    public static Client of(ClientId clientId, String lastname, String firstname, Address address) {
        return new Client(clientId, lastname, firstname, address);
    }

    @Pattern.StaticFactoryMethod
    public static Client of(ClientId clientId, String lastname, String firstname) {
        return new Client(clientId, lastname, firstname, AddressFactory.noAddress());
    }

    public void modifyAddress(Address newAddress) {
        this.address = newAddress;
    }

    public String lastname() {
        return lastname;
    }

    public String firstname() {
        return firstname;
    }

    public Address address() {
        return address;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(clientId, client.clientId) && Objects.equals(lastname, client.lastname) && Objects.equals(firstname, client.firstname) && Objects.equals(address, client.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, lastname, firstname, address);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", address=" + address +
                '}';
    }
}
