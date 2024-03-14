package pl.praktycznajava.module5.grasp.challenge1;

import pl.praktycznajava.module5.grasp.challenge1.example.Priority;
import pl.praktycznajava.module5.grasp.challenge1.example.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TaskMapper implements RowMapper<Task> {
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
