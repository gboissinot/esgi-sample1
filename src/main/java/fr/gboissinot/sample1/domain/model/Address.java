package fr.gboissinot.sample1.domain.model;

@SuppressWarnings("unused")
public interface Address {

    String country();

    String city();

    String street();

    ZipCode zipCode();

    boolean isAddress();
}
