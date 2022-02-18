package com.university.java.app.file.fileReader;

import com.university.java.app.file.lists.FacultyList;
import com.university.java.app.file.lists.StudentList;
import com.university.java.app.model.Faculty;
import com.university.java.app.model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FacultiesFileReader {

    private static final String PATH = "src/main/java/com/university/java/app/file/data/faculties.bat";
    private static final File FILE = new File(PATH);

    public void clearFile() {
        try {
            FILE.delete();
            FILE.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Faculty> findAll() {
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
            e.printStackTrace();
        }
        return faculties;
    }

    public void addToFile(Faculty faculty) {
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
