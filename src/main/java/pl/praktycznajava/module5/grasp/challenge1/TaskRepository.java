package pl.praktycznajava.module5.grasp.challenge1;

import pl.praktycznajava.module5.grasp.challenge1.example.RowMapper;

public interface TaskRepository {
    void update(String sql, Object... args);

    Task queryForObject(String sql, RowMapper rowMapper, String taskId);

    default Task loadFromDatabase(String id, Task task) {
        String sql = "SELECT * FROM tasks WHERE id = ?";
        return queryForObject(sql, new TaskMapper(), id);
    }

    default void saveToDatabase(Task task) {
        String sql = "INSERT INTO tasks (id, description, due_date, priority, completed) VALUES (?, ?, ?, ?, ?)";
        update(sql, task.getId(), task.getDescription(),
                task.getDueDate(), task.getPriority().name(), task.isCompleted());
    }
}
