package pl.praktycznajava.module5.grasp.challenge2.example;

import pl.praktycznajava.module5.grasp.challenge1.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

// na potrzeby zadania
public interface RowMapper<T> {

    Task mapRow(ResultSet resultSet, int rowNum) throws SQLException;
}
