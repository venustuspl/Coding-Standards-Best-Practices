package pl.praktycznajava.module5.grasp.challenge3;

import lombok.NoArgsConstructor;
import pl.praktycznajava.module5.grasp.challenge3.model.AccountBalance;
import pl.praktycznajava.module5.grasp.challenge3.model.Amount;
import pl.praktycznajava.module5.grasp.challenge3.model.Grades;
import pl.praktycznajava.module5.grasp.challenge3.model.Percentage;
import pl.praktycznajava.module5.grasp.challenge3.model.order.Order;
import pl.praktycznajava.module5.grasp.challenge3.util.OperationsUtil;

@NoArgsConstructor
public class Challenge3Service {

    // -------------------------------------------------------------------------------------------------------
    // Challenge 3.
    // Mamy tutaj kilka przykładowych metod, które korzystają z klasy OperationsUtil,
    // która nie spełnia zasady High Cohesion.
    // Zrefaktoryzuj kod w taki sposób, aby została spełniona zasada High Cohesion.
    // Przykładowo możemy wynieść te metody do konkretnych obiektów, których one dotyczą,
    // gdzie będą spójną częścią.
    // -------------------------------------------------------------------------------------------------------


    void transferMoney(AccountBalance sender, AccountBalance receiver, Amount transferAmount) {
        Amount receiverBalance = receiver.getBalance().add(transferAmount);
        Amount senderBalance = receiver.getBalance().subtract(transferAmount);
        // dalsze działania
    }

    public Amount calculateDiscountedPrice(Order order, Percentage percentageDiscount) {
        Amount totalAmount = order.getTotalAmount();
        Amount discountAmount = percentageDiscount.getDiscountAmountByPercentage(totalAmount);
        Amount discountedAmount = totalAmount.subtract(discountAmount);
        return discountedAmount;
    }


    boolean isSubjectPassed(Grades grades, Double minimumAverage) {
        double calculatedAverage = grades.calculateAverage();
        // dalsze wyliczenia
        return false;
    }

}