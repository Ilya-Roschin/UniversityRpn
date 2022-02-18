package com.university.java.app.repository;

import com.university.java.app.file.fileReader.StudentFileReader;
import com.university.java.app.model.Student;

import java.util.List;

public class StudentRepository {

    private static final StudentFileReader STUDENT_FILE_READER = new StudentFileReader();

    public void addToRepository(Student student) {
        STUDENT_FILE_READER.addToFile(student);
    }

    public Student findByName(String name) {
        // TODO: 01.02.2022 create new exception
        return STUDENT_FILE_READER.findAll().stream()
                .filter(u -> u.getUserName().equals(name))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public List<Student> findAll() {
        return STUDENT_FILE_READER.findAll();
    }

    public void DeleteUser(Student student) {
       STUDENT_FILE_READER.deleteStudent(student);
    }

    public void updateStudent(String studentName, Student updatedStudent) {
        STUDENT_FILE_READER.update(studentName, updatedStudent);
    }
}
