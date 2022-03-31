package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.HashMap;

public class StudentService {

    private HashMap<Long, Student>  students = new HashMap<>();
    private long lastId = 0;

    public Student createStudent(Student student) {
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }

    public Student editStudent(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    public Student findStudent(Long id) {
        return students.get(id);
    }

    public Student deleteStudent(Long id) {
        return students.remove(id);
    }

}
