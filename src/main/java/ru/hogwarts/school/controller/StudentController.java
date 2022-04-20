package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundstudent = studentService.editStudent(student);
        if (foundstudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return student;
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("{age}")
//    public List<Student> getStudentsByAge(@PathVariable int age) {
//        return studentService.getAgeStudents(age);
//    }

    @GetMapping({"min"})
    public List<Student> getStudentByAgeBetweenMinAndMax(@PathVariable(required = false) Integer min,
                                                               @PathVariable(required = false) Integer max) {
        return studentService.findByAgeBetween(min, max);
    }
}
