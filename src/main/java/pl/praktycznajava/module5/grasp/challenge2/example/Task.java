package pl.praktycznajava.module5.grasp.challenge2.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class Task {

    private final String id;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

}