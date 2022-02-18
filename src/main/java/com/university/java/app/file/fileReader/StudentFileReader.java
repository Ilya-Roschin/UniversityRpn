package com.university.java.app.file.fileReader;

import com.university.java.app.file.lists.StudentList;
import com.university.java.app.model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentFileReader implements Serializable {

    private static final String PATH = "src/main/java/com/university/java/app/file/data/students.bat";
    private static final File FILE = new File(PATH);

    public void clearFile() {
        try {
            FILE.delete();
            FILE.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> findAll() {
        FileInputStream fileInputStream = null;
        List<Student> students = new ArrayList<>();
        try {
            if (FILE.length() != 0) {
                fileInputStream = new FileInputStream(PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                StudentList studentList = (StudentList) objectInputStream.readObject();
                students = studentList.getStudents();
                objectInputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void addToFile(Student student) {
        FileOutputStream outputStream = null;
        List<Student> students = findAll();
        try {

            outputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            students.add(student);
            objectOutputStream.writeObject(new StudentList(students));

            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student, Student updatedStudent) {
        List<Student> students = findAll();
        for (int i = 0; i < students.size(); i++) {
            if (Objects.equals(students.get(i), student)) {
                students.remove(student);
                students.add(updatedStudent);
                System.out.println(updatedStudent);
            }
        }

        clearFile();

        for (Student s : students) {
            addToFile(s);
        }
    }

    public void deleteStudent(Student student) {
        List<Student> students = findAll();
        for (int i = 0; i < students.size(); i++) {
            if (Objects.equals(students.get(i), student)) {
                students.remove(student);
                break;
            }
        }
    }
}
