package pl.praktycznajava.module5.grasp.challenge3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@AllArgsConstructor(staticName = "of")
public class Percentage {

    private static final long MAX_PERCENT = 100;

    private final int value;

    public Amount getDiscountAmountByPercentage(Amount amount) {
        BigDecimal discountAmount = amount.getValue().multiply(BigDecimal.valueOf(this.getValue()))
                .divide(BigDecimal.valueOf(MAX_PERCENT), RoundingMode.HALF_UP);
        return Amount.of(discountAmount);
    }

}
