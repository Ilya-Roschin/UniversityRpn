package com.university.java.app.repository;

import com.university.java.app.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRepository {

    private static final List<Student> STUDENTS = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    public void addToRepository(Student student) {
        STUDENTS.add(student);
    }

    public Student findByName(String name) {
        // TODO: 01.02.2022 create new exception
        return STUDENTS.stream()
                .filter(u -> u.getUserName().equals(name))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public List<Student> findAll() {
        return STUDENTS;
    }

    public boolean DeleteStudentByName(String username) {
        return STUDENTS.remove(findByName(username));
    }

    public boolean DeleteUser(Student student) {
        return STUDENTS.remove(student);
    }

    public void updateStudent(Student findStudent, Student updatedStudent) {
        DeleteUser(findStudent);
        addToRepository(updatedStudent);
    }
}
