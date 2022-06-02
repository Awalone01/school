package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.model.AllStudents;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
public class AllStudentsController {

    private final StudentService studentService;

    public AllStudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all-students")
    public List<AllStudents> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/AVG-age")
    public List<AllStudents> getAverageAgeByStudents() {
        return studentService.getAverageAgeByStudents();
    }

}
