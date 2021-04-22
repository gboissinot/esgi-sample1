package fr.gboissinot.sample1.domain.model;

import fr.gboissinot.kernel.java.annotation.Pattern;

@Pattern.Factory
public class AddressFactory {

    private AddressFactory() {
        throw new AssertionError();
    }

    public static Address of(String country, String city, String street, String zipCode) {
        return new DefaultAddress(country, city, street, zipCode);
    }

    public static Address noAddress() {
        return new NoAddress();
    }
}
