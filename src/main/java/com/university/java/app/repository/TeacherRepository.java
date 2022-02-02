package com.university.java.app.repository;

import com.university.java.app.model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherRepository {

    private static final List<Teacher> TEACHERS = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    public void addToRepository(Teacher teacher) {
        TEACHERS.add(teacher);
    }

    public List<Teacher> findAll() {
        return TEACHERS;
    }

    public Teacher findByName(String name) {
        // TODO: 01.02.2022 create new exception
        return TEACHERS.stream()
                .filter(u -> u.getUserName().equals(name))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

}
