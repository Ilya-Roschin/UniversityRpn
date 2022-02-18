package com.university.java.app.file.fileReader;

import com.university.java.app.file.lists.TeacherList;
import com.university.java.app.model.Teacher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TeacherFileReader {

    private static final String PATH = "src/main/java/com/university/java/app/file/data/teachers.bat";
    private static final File FILE = new File(PATH);

    public void clearFile() {
        try {
            FILE.delete();
            FILE.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> findAll() {
        FileInputStream fileInputStream = null;
        List<Teacher> teachers = new ArrayList<>();
        try {
            if (FILE.length() != 0) {
                fileInputStream = new FileInputStream(PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                TeacherList studentList = (TeacherList) objectInputStream.readObject();
                teachers = studentList.getTeachers();
                objectInputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public void addToFile(Teacher teacher) {
        FileOutputStream outputStream = null;
        List<Teacher> teachers = findAll();
        try {

            outputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            teachers.add(teacher);
            objectOutputStream.writeObject(new TeacherList(teachers));

            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
