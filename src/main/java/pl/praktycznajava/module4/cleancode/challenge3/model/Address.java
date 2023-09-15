package pl.praktycznajava.module4.cleancode.challenge3.model;

import lombok.Value;

@Value(staticConstructor = "of")
public class Address {
    String street;
    String postalCode;
    String city;
    String country;
}
