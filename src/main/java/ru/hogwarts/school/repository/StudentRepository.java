package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.AllStudents;
import ru.hogwarts.school.model.Student;

import java.util.List;
import java.util.Set;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Set<Student> findByAge(Integer age);

    Set<Student> findByAgeBetween(Integer min, Integer max);

    @Query(value = "SELECT name, COUNT(name) as name FROM studwnts", nativeQuery = true)
    List<AllStudents> getAllStudents();
}
