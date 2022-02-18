package com.university.java.app.fileRepository;

import com.university.java.app.model.Student;

import java.io.*;

public class StudentFileReader implements Serializable {

    public void clearFile() {

    }

    public void readFirstStudent() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/java/com/university/java/app/fileRepository/data/students.bat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Student student = (Student) objectInputStream.readObject();
            System.out.println(student.getUserName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("src/main/java/com/university/java/app/fileRepository/data/students.bat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(student);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
