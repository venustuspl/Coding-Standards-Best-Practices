package pl.praktycznajava.module5.grasp.challenge2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.praktycznajava.module5.grasp.challenge2.example.Task;
import pl.praktycznajava.module5.grasp.challenge2.repository.ProjectRepositoryImpl;

import java.util.List;

@Getter
@AllArgsConstructor
public class Project {

    // -------------------------------------------------------------------------------------------------------
    // Challenge 2.
    // Zrefaktoryzuj ten obiekt w taki sposób, aby była spełniona zasada Low Coupling.
    // Spraw, aby ta klasa była jak najmniej zależna od innych klas.
    // Przykładowo zamiast być zależnym od konkretnej implementacji warto wyodrębnić interfejs,
    // stworzyć pośrednika, dzięki któremu możemy uzyskąć luźny coupling.
    // -------------------------------------------------------------------------------------------------------


    private String projectName;
    private String projectDescription;
    private List<Task> tasks;

    public void changeProjectName(String newProjectName, ProjectRepositoryImpl projectRepositoryImpl) {
        if (projectRepositoryImpl.isNameDuplicate(newProjectName)) {
            throw new IllegalArgumentException("Project with the same name already exists.");
        }
        this.projectName = newProjectName;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }


}