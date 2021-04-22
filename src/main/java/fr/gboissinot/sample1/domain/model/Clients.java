package fr.gboissinot.sample1.domain.model;

import fr.gboissinot.kernel.java.annotation.ddd.DDD;

@DDD.Repository
public interface Clients {

    Client findById(ClientId clientId);

    void add(Client client);
}
