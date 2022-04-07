package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final HashMap<Long, Faculty> facultyMap = new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        facultyMap.put(lastId, faculty);
        return faculty;
    }

    public Faculty editFaculty(Faculty faculty) {
        facultyMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty findFaculty(Long id) {
        return facultyMap.get(id);
    }

    public Faculty deleteFaculty(Long id) {
        return facultyMap.remove(id);
    }

    public List<Faculty> getAllFaculties() {
        return new ArrayList<>(facultyMap.values());
    }

    public List<Faculty> getFacultiesByColor(String color) {
        return getAllFaculties().stream().
                filter(s -> Objects.equals(s.getColor(), color)).
                collect(Collectors.toList());
    }
}
