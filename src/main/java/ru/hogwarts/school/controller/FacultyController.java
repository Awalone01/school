package ru.hogwarts.school.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

@RestController
@RequestMapping("facultys")
public class FacultyController {

    private final FacultyService facultyService;


    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createStudent(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public Faculty editStudent(@RequestBody Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }

    @GetMapping("{id}")
    public Faculty getStudent(@PathVariable Long id) {
        return facultyService.findFaculty(id);
    }

    @DeleteMapping("{id}")
    public Faculty deleteStudent(@PathVariable Long id) {
        return facultyService.deleteFaculty(id);
    }
}
