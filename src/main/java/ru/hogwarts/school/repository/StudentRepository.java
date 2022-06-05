package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.List;
import java.util.Set;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Set<Student> findByAge(Integer age);

    Set<Student> findByAgeBetween(Integer min, Integer max);

    @Query(value = "SELECT COUNT (*) FROM student", nativeQuery = true)
    int getCountOfStudents();

    @Query(value = "SELECT AVG (age) as age FROM student", nativeQuery = true)
    double avgAge();

    @Query(value = "SELECT * FROM student OFFSET 5", nativeQuery = true)
    List<Student> getLastFiveStudents();


}
