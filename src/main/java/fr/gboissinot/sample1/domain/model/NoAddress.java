package fr.gboissinot.sample1.domain.model;

import fr.gboissinot.kernel.java.annotation.ddd.DDD;

@DDD.ValueObject
class NoAddress implements Address {

    @Override
    public String country() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String city() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String street() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String zipCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isAddress() {
        return false;
    }

    @Override
    public String toString() {
        return "NoAddress{}";
    }
}
