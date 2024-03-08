package pl.praktycznajava.module5.grasp.challenge2.example;

import pl.praktycznajava.module5.grasp.challenge1.Task;
import pl.praktycznajava.module5.grasp.challenge2.Project;

import java.sql.ResultSet;
import java.sql.SQLException;

// na potrzeby zadania
public class BeanPropertyRowMapper implements RowMapper {
    public BeanPropertyRowMapper(Class<Project> projectClass) {
    }

    @Override
    public Task mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return null;
    }
}
