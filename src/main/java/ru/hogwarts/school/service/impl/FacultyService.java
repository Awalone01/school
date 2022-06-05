package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Set;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(Long id) {
        return facultyRepository.findById(id).get();
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    public Set<Faculty> getByColorIgnoreCase(String color) {
        return facultyRepository.getByColorIgnoreCase(color);
    }

    public Set<Faculty> findByColorOrNameIgnoreCase(String color, String name) {
        return facultyRepository.getByColorOrNameIgnoreCase(color, name);
    }
}
