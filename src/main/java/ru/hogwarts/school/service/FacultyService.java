package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.Optional;
import java.util.Set;

public interface FacultyService {

    Set<Faculty> getByColorIgnoreCase(String color);

    Set<Faculty> findByColorOrNameIgnoreCase(String color, String name);

    Optional<String> theLongestNameOfFaculty();
}
