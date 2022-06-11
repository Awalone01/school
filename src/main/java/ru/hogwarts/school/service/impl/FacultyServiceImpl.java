package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.service.FacultyService;

import java.util.*;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
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

    @Override
    public Set<Faculty> getByColorIgnoreCase(String color) {
        return facultyRepository.getByColorIgnoreCase(color);
    }

    @Override
    public Set<Faculty> findByColorOrNameIgnoreCase(String color, String name) {
        return facultyRepository.getByColorOrNameIgnoreCase(color, name);
    }

    @Override
    public Optional<String> theLongestNameOfFaculty() {
        return facultyRepository.findAll().stream()
                .map(Faculty::getName)
                .max(Comparator.comparing(String::length));
    }
}
