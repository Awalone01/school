package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.impl.AvatarServiceImpl;
import ru.hogwarts.school.service.impl.StudentServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService, AvatarServiceImpl avatarService) {
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

    @GetMapping(params = {"age"})
    public Set<Student> getStudentsByAge(@RequestParam(required = false) Integer age) {
        return studentService.getAgeStudents(age);
    }

    @GetMapping(params = {"minAge", "maxAge"})
    public Set<Student> getStudentByAgeBetweenMinAndMax(
            @RequestParam(required = false) Integer min,
            @RequestParam(required = false) Integer max) {
        return studentService.findByAgeBetween(min, max);
    }

    @GetMapping("/count-students")
    public int count() {
        return studentService.countOfStudents();
    }

    @GetMapping("/AVG-age")
    public double avgAge() {
        return studentService.avgAge();
    }

    @GetMapping("last-five-students")
    ResponseEntity<List<Student>> getLastFiveStudents() {
        List<Student> lastFiveStudents = studentService.getLastFiveStudents();
        return ResponseEntity.ok(lastFiveStudents);
    }

    @GetMapping("/filterStudentsByFirstLetterInName")
    public ResponseEntity<List<String>> filterStudentsByFirstLetterInName() {
        List<String> filterStudents = studentService.filterStudentsByFirstLetterInName();
        return ResponseEntity.ok(filterStudents);
    }

    @GetMapping("/filterByAvgAge")
    public Double filterByAvgAge() {
        return studentService.getAverageAge();
    }

    @GetMapping("/parallelThread")
    public void getParallelThread() {
        studentService.getParallelThread();
    }

    @GetMapping("/syncThread")
    public void getSyncThread() {
        studentService.getSyncThread();
    }
}
