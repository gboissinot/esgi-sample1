package fr.gboissinot.sample1.domain.model;

import fr.gboissinot.kernel.java.annotation.Pattern;
import fr.gboissinot.kernel.java.annotation.ddd.DDD;

import java.util.Objects;

@SuppressWarnings("unused")
@DDD.ValueObjectId
public class ClientId {

    private final String value;

    private ClientId(String value) {
        this.value = value;
    }

    @Pattern.StaticFactoryMethod
    public static ClientId of(String value) {
        return new ClientId(value);
    }

    @Pattern.StaticFactoryMethod
    public static ClientId of(int value) {
        return new ClientId(String.valueOf(value));
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientId clientId = (ClientId) o;
        return Objects.equals(value, clientId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ClientId{" +
                "value='" + value + '\'' +
                '}';
    }
}
