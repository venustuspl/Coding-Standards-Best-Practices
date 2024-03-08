package pl.praktycznajava.module5.grasp.challenge3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor(staticName = "of")
public class Grades {
    private final List<Double> grades;
}
