package com.university.java.app.file.fileReader;

import com.university.java.app.exception.IncorrectInputException;
import com.university.java.app.file.lists.FacultyList;
import com.university.java.app.model.Faculty;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FacultiesFileReader {

    private static final String PATH = "src/main/java/com/university/java/app/file/data/faculties.bat";
    private static final File FILE = new File(PATH);

    public void clearFile() throws IncorrectInputException{
        try {
            FILE.delete();
            FILE.createNewFile();
        } catch (IOException e) {
            System.out.println("io exception");
            throw new IncorrectInputException("IOException", e);
        }
    }

    public List<Faculty> findAll() throws IncorrectInputException{
        FileInputStream fileInputStream = null;
        List<Faculty> faculties = new ArrayList<>();
        try {
            if (FILE.length() != 0) {
                fileInputStream = new FileInputStream(PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                FacultyList facultyList = (FacultyList) objectInputStream.readObject();
                faculties = facultyList.getFaculties();
                objectInputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("exception");
            throw new IncorrectInputException("IOException", e);
        }
        return faculties;
    }

    public void addToFile(Faculty faculty) throws IncorrectInputException {
        FileOutputStream outputStream = null;
        List<Faculty> faculties = findAll();
        try {

            outputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            faculties.add(faculty);
            objectOutputStream.writeObject(new FacultyList(faculties));

            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
