package pl.praktycznajava.module5.grasp.challenge2.repository;

import pl.praktycznajava.module5.grasp.challenge2.Project;

public interface ProjectRepository {
    void saveProject(Project project);

    void deleteProject(Project project);

    Project getProjectByName(String projectName);

    boolean isNameDuplicate(String newProjectName);
}
