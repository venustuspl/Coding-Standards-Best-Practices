package pl.praktycznajava.module4.cleancode.challenge2.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
public class Product {

    String name;
    double price;
    int stockQuantity;
    double weight;

    public boolean isAvailable() {
        return this.stockQuantity > 0;
    }

}
