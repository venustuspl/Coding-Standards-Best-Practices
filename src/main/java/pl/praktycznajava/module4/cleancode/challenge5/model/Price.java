package pl.praktycznajava.module4.cleancode.challenge5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class Price {
    double value;

    public Price getByPercentage(double discountPercentage) {
        // FIXME nieskończona implementacja
        return null;
    }
}
