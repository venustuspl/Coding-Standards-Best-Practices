package pl.praktycznajava.module5.grasp.challenge1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import pl.praktycznajava.module5.grasp.challenge1.example.JdbcTemplate;
import pl.praktycznajava.module5.grasp.challenge1.example.Priority;
import pl.praktycznajava.module5.grasp.challenge1.example.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    private final JdbcTemplate jdbcTemplate;

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

    public void saveToDatabase(Task task) {
        String sql = "INSERT INTO tasks (id, description, due_date, priority, completed) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, task.getId(), task.getDescription(),
                task.getDueDate(), task.getPriority().name(), task.isCompleted());
    }

    public Task loadFromDatabase(String id) {
        String sql = "SELECT * FROM tasks WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new TaskMapper(), id);
    }

    private static class TaskMapper implements RowMapper<Task> {
        @Override
        public Task mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return Task.builder()
                    .id(resultSet.getString("id"))
                    .description(resultSet.getString("description"))
                    .dueDate(resultSet.getDate("due_date").toLocalDate())
                    .priority(Priority.valueOf(resultSet.getString("priority")))
                    .completed(resultSet.getBoolean("completed"))
                    .build();
        }
    }

}