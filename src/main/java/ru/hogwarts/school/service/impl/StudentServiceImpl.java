package ru.hogwarts.school.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.info("Was invoked method to create a student: {}", student);
        return studentRepository.save(student);
    }

    public Student editStudent(Student student) {
        logger.info("Was invoked method to edit a student: {}", student);
        return studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        logger.info("Was invoked method to find a student by ID: {}", id);
        return studentRepository.findById(id).get();
    }

    public void deleteStudent(Long id) {
        logger.info("Was invoked method to delete a student by ID: {}", id);
        studentRepository.deleteById(id);
    }

    public Set<Student> getAgeStudents(int age) {
        logger.info("Was invoked method to find by age: {}", age);
        return studentRepository.findByAge(age);
    }

     public Set<Student> findByAgeBetween(Integer min, Integer max) {
        logger.debug("Was invoked method to find age in range: {} and {}", min, max);
         return studentRepository.findByAgeBetween(min, max);
     }

    @Override
    public int countOfStudents() {
        return studentRepository.getCountOfStudents();
    }

    @Override
    public double avgAge() {
        return studentRepository.avgAge();
    }

    @Override
    public List<Student> getLastFiveStudents() {
        return studentRepository.getLastFiveStudents();
    }
}