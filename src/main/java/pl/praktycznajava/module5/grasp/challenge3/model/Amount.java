package pl.praktycznajava.module5.grasp.challenge3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor(staticName = "of")
public class Amount {
    private final BigDecimal value;

    public Amount subtract(Amount second) {
        if (second == null) {
            return null;
        }
        return Amount.of(this.getValue().subtract(second.getValue()));
    }

    public Amount add(Amount second) {
        if (second == null) {
            return null;
        }
        return Amount.of(this.getValue().add(second.getValue()));
    }
}
