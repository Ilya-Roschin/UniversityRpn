package com.university.java.app.repository;

import com.university.java.app.exception.IncorrectInputException;
import com.university.java.app.file.fileReader.FacultiesFileReader;
import com.university.java.app.model.Faculty;

import java.util.List;

public class FacultyRepository {

    private static final FacultiesFileReader FACULTIES_FILE_READER = new FacultiesFileReader();

    public void addToRepository(Faculty faculty) throws IncorrectInputException {
        FACULTIES_FILE_READER.addToFile(faculty);
    }

    public List<Faculty> findAll() throws IncorrectInputException{
        return FACULTIES_FILE_READER.findAll();
    }

    public Faculty findByName(String name) throws IncorrectInputException{
        return FACULTIES_FILE_READER.findAll().stream()
                .filter(u -> u.getFacultyName().equals(name))
                .findFirst()
                .orElseThrow(IncorrectInputException::new);
    }
}
