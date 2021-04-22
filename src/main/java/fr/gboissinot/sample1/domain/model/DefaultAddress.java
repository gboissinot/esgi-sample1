package fr.gboissinot.sample1.domain.model;

import fr.gboissinot.kernel.java.annotation.ddd.DDD;

import java.util.Objects;

@DDD.ValueObject
class DefaultAddress implements Address {

    private final String country;
    private final String city;
    private final String street;
    private final ZipCode zipCode;

    DefaultAddress(String country, String city, String street, ZipCode zipCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    @Override
    public String country() {
        return country;
    }

    @Override
    public String city() {
        return city;
    }

    @Override
    public String street() {
        return street;
    }

    @Override
    public ZipCode zipCode() {
        return zipCode;
    }

    @Override
    public boolean isAddress() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultAddress address = (DefaultAddress) o;
        return Objects.equals(country, address.country) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, street, zipCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
