package com.university.java.app.repository;

import com.university.java.app.exception.IncorrectInputException;
import com.university.java.app.file.fileReader.StudentFileReader;
import com.university.java.app.model.Student;

import java.util.List;

public class StudentRepository {

    private static final StudentFileReader STUDENT_FILE_READER = new StudentFileReader();

    public void addToRepository(Student student) throws IncorrectInputException{
        STUDENT_FILE_READER.addToFile(student);
    }

    public Student findByName(String name) throws IncorrectInputException{
        // TODO: 01.02.2022 create new exception
        return STUDENT_FILE_READER.findAll().stream()
                .filter(u -> u.getUserName().equals(name))
                .findFirst()
                .orElseThrow(IncorrectInputException::new);
    }

    public List<Student> findAll() throws IncorrectInputException{
        return STUDENT_FILE_READER.findAll();
    }

    public void DeleteUser(Student student) throws IncorrectInputException{
       STUDENT_FILE_READER.deleteStudent(student);
    }

    public void updateStudent(String studentName, Student updatedStudent) throws IncorrectInputException {
        STUDENT_FILE_READER.update(studentName, updatedStudent);
    }
}
