package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentService {

    int countOfStudents();

    double avgAge();

    List<Student> getLastFiveStudents();

    List<String> filterStudentsByFirstLetterInName();

    Double getAverageAge();

    void getParallelThread();

    void getSyncThread();



}
