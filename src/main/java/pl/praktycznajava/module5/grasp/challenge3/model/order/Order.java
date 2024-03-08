package pl.praktycznajava.module5.grasp.challenge3.model.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import pl.praktycznajava.module5.grasp.challenge3.model.Amount;

import java.util.List;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class Order {

   List<OrderItem> items;
   Amount totalAmount;
   Currency currency;

   public void changeTotalAmount(Amount totalAmount, Currency currency) {
      this.totalAmount = totalAmount;
      this.currency = currency;
   }

}