package pl.praktycznajava.module4.cleancode.challenge5.model;

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
    Price price;
    int stockQuantity;
    double weight;

    public boolean isAvailable() {
        return this.stockQuantity > 0;
    }

    public void addDiscount(Price discount) {

    }

    public String getType() {
        return null;
    }
}
