package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Set<Student> findByAge(Integer age);

    Set<Student> findByAgeBetween(Integer min, Integer max);
}