package pl.praktycznajava.module5.grasp.challenge3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class AccountNumber {
    private final String number;
}
