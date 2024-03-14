package pl.praktycznajava.module5.grasp.challenge1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.praktycznajava.module5.grasp.challenge1.example.JdbcTemplate;
import pl.praktycznajava.module5.grasp.challenge1.example.Priority;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class Task {

    // -------------------------------------------------------------------------------------------------------
    // Challenge 1.
    // Zrefaktoryzuj ten obiekt w taki sposób, aby była spełniona zasada High Cohesion.
    // Możesz wykorzystać zasadę Pure Fabrications.
    // -------------------------------------------------------------------------------------------------------


    private final String id;
    private String description;
    private LocalDate dueDate;
    private Priority priority;
    private boolean completed;

    public void markAsCompleted() {
        this.completed = true;
    }

    public void changePriority(Priority newPriority) {
        this.priority = newPriority;
    }

    public void changeDescription(String description) {
        this.description = description;
    }

    public boolean isLate() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.isAfter(dueDate);
    }

}