package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private final HashMap<Long, Student>  students = new HashMap<>();
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

    public HashMap<Long, Student> getAgeStudents(int age) {
        HashMap<Long, Student> filteredMap = new HashMap<>();
        for (Map.Entry student : students.entrySet()) {
            if (student.getValue().equals(age)) {
                filteredMap.put((Long) student.getKey(), (Student) student.getValue());
            }
        }
        return filteredMap;
    }
//        Student newStudent = new Student();
//        for (int i = 0; i < students.size(); i++) {
//            if (age == students.get().getAge()) {
//                return Collection<Student>.;
//            }
//        }
    }