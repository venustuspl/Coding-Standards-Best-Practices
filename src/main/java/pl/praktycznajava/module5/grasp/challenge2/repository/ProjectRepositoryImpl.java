package pl.praktycznajava.module5.grasp.challenge2.repository;

import lombok.AllArgsConstructor;
import pl.praktycznajava.module5.grasp.challenge2.Project;
import pl.praktycznajava.module5.grasp.challenge2.example.BeanPropertyRowMapper;
import pl.praktycznajava.module5.grasp.challenge2.example.JdbcTemplate;

@AllArgsConstructor
public class ProjectRepositoryImpl {

    private final JdbcTemplate jdbcTemplate;

    public void saveProject(Project project) {
        String sql = "INSERT INTO projects (project_name, project_description) VALUES (?, ?)";
        jdbcTemplate.update(sql, project.getProjectName(), project.getProjectDescription());
    }

    public void deleteProject(Project project) {
        String sql = "DELETE FROM projects WHERE project_name = ?";
        jdbcTemplate.update(sql, project.getProjectName());
    }

    public Project getProjectByName(String projectName) {
        String sql = "SELECT * FROM projects WHERE project_name = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Project.class), projectName);
    }

    public boolean isNameDuplicate(String newProjectName) {
        String sql = "SELECT COUNT(*) FROM projects WHERE project_name = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, newProjectName);
        return count != null && count > 0;
    }
}
