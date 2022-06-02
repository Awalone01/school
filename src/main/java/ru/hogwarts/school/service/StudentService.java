package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.AllStudents;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Set<Student> getAgeStudents(int age) {
        return studentRepository.findByAge(age);
    }

     public Set<Student> findByAgeBetween(Integer min, Integer max) {
         return studentRepository.findByAgeBetween(min, max);
     }

     public List<AllStudents> getAllStudents() {
         return studentRepository.getAllStudents();
     }
}