package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;

import java.util.Set;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Set<Faculty> getByColorIgnoreCase(String color);

    Set<Faculty> getByColorOrNameIgnoreCase(String color, String name);
}
