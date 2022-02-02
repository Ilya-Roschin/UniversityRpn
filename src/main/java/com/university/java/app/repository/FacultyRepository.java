package com.university.java.app.repository;

import com.university.java.app.model.Faculty;

import java.util.ArrayList;
import java.util.List;

public class FacultyRepository {

    private static final List<Faculty> FACULTIES = new ArrayList<>();

    public void addToRepository(Faculty faculty) {
        FACULTIES.add(faculty);
    }

    public List<Faculty> findAll() {
        return FACULTIES;
    }

    public Faculty findByName(String name) {
        // TODO: 01.02.2022 create new exception
        return FACULTIES.stream()
                .filter(u -> u.getFacultyName().equals(name))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
