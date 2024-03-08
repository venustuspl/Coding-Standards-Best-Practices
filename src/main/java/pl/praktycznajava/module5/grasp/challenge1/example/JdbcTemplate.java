package pl.praktycznajava.module5.grasp.challenge1.example;

import pl.praktycznajava.module5.grasp.challenge1.Task;

// na potrzeby zadania
public interface JdbcTemplate {
    void update(String sql, Object... args);

    Task queryForObject(String sql, RowMapper rowMapper, String taskId);
}
