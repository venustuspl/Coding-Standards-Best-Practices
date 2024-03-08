package pl.praktycznajava.module5.grasp.challenge3.util;

import pl.praktycznajava.module5.grasp.challenge3.model.Amount;
import pl.praktycznajava.module5.grasp.challenge3.model.Grades;
import pl.praktycznajava.module5.grasp.challenge3.model.Percentage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class OperationsUtil {
    private static final long MAX_PERCENT = 100;

    public static Amount subtract(Amount first, Amount second) {
        if (first == null || second == null) {
            return null;
        }
        return Amount.of(first.getValue().subtract(second.getValue()));
    }

    public static Amount add(Amount first, Amount second) {
        if (first == null || second == null) {
            return null;
        }
        return Amount.of(first.getValue().add(second.getValue()));
    }

    public static Amount getDiscountAmountByPercentage(Amount amount, Percentage percentageDiscount) {
        BigDecimal discountAmount = amount.getValue().multiply(BigDecimal.valueOf(percentageDiscount.getValue()))
                .divide(BigDecimal.valueOf(MAX_PERCENT), RoundingMode.HALF_UP);
        return Amount.of(discountAmount);
    }

    public static double calculateAverage(Grades grades) {
        List<Double> numbers = grades.getGrades();
        if (numbers.size() == 0) {
            return 0;
        }
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.size();
    }
}
