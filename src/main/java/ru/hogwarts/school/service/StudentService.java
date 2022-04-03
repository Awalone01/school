package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;
import ru.hogwarts.school.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Student getAgeStudents(int age) {
        return (Student) getAllStudents().stream().
                filter(s -> s.getAge() == age);
    }


//        Map<Long, Student> filteredMap = students.entrySet().stream().
//                filter(students -> students.getValue().getAge()).
//                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//        return filteredMap;
        ///////////////////////////////////////////////////////////////////////////
//        List<Student> studentList = students.entrySet().stream().
//                flatMap(students -> students.getValue().getAge(age)).collect(Collectors.toList());
//        return (Student) studentList;
//    }
///////////////////////////////////////////////////////////
//    public HashMap<Long, Student> getAgeStudents(int age) {
//        HashMap<Long, Student> filteredMap = new HashMap<>();
//        for (Map.Entry student : students.entrySet()) {
//            if (student.getValue().equals(age)) {
//                filteredMap.put((Long) student.getKey(), (Student) student.getValue());
//            }
//        }
//        return filteredMap;
//    }
/////////////////////////////////////////////////////////
//        Student newStudent = new Student();
//        for (int i = 0; i < students.size(); i++) {
//            if (age == students.get().getAge()) {
//                return Collection<Student>.;
//            }
//        }
    }
