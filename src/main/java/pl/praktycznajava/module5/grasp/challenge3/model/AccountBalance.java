package pl.praktycznajava.module5.grasp.challenge3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountBalance {
    private AccountNumber number;
    private Amount balance;
}
