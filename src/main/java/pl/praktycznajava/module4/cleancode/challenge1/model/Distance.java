package pl.praktycznajava.module4.cleancode.challenge1.model;

import lombok.Getter;

@Getter
public class Distance {

    private final double kilometers;

    public Distance(double kilometers) {
        this.kilometers = kilometers;
    }
}
