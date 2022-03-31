package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;

public class FacultyService {

    private HashMap<Long, Faculty> facultyMap = new HashMap<>();
    private long lastId = 0;
}
