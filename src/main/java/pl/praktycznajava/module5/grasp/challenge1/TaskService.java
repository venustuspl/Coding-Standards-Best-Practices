package pl.praktycznajava.module5.grasp.challenge1;

import pl.praktycznajava.module5.grasp.challenge1.example.RowMapper;

public class TaskService implements TaskRepository {
    @Override
    public void update(String sql, Object... args) {

    }

    @Override
    public Task queryForObject(String sql, RowMapper rowMapper, String taskId) {
        return null;
    }
}
