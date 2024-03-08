package pl.praktycznajava.module5.grasp.challenge3.model.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pl.praktycznajava.module3.valueobjects.challenge2.model.Product;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class OrderItem {

    Product product;
    int quantity;

}
