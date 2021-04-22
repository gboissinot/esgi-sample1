package fr.gboissinot.kernel.ddd;

import fr.gboissinot.kernel.java.annotation.ddd.DDD;

import java.util.Optional;

@DDD.Repository
public interface AggregateRepository<ID extends AggregateId, A extends AggregateRootType> {
    Optional<A> findById(ID id);

    void add(A aggregate);

    void delete(ID id);

    ID nextIdentity();
}
