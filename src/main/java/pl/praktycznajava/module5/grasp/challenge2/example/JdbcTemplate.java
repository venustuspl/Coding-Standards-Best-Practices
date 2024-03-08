package pl.praktycznajava.module5.grasp.challenge2.example;

// na potrzeby zadania
public interface JdbcTemplate {
    void update(String sql, Object... args);

    <T> T  queryForObject(String sql, RowMapper rowMapper, Object... args);

    <T> T queryForObject(String sql, Class<T> requiredType, Object... args);
}
