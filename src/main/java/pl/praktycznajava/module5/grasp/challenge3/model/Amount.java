package pl.praktycznajava.module5.grasp.challenge3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor(staticName = "of")
public class Amount {
    private final BigDecimal value;
}
