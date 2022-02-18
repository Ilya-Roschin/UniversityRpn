package com.university.java.app.repository;

import com.university.java.app.file.fileReader.TeacherFileReader;
import com.university.java.app.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepository {

    private static final List<Teacher> TEACHERS = new ArrayList<>();
    private static final TeacherFileReader TEACHER_FILE_READER = new TeacherFileReader();

    public void addToRepository(Teacher teacher) {
        TEACHER_FILE_READER.addToFile(teacher);
    }

    public Teacher findByName(String name) {
        return TEACHER_FILE_READER.findAll().stream()
                .filter(u -> u.getUserName().equals(name))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

}
