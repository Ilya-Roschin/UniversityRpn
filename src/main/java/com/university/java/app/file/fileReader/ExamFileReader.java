package com.university.java.app.file.fileReader;

import com.university.java.app.file.lists.ExamList;
import com.university.java.app.file.lists.StudentList;
import com.university.java.app.model.Exam;
import com.university.java.app.model.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExamFileReader {

    private static final String PATH = "src/main/java/com/university/java/app/file/data/exams.bat";
    private static final File FILE = new File(PATH);

    public void clearFile() {
        try {
            FILE.delete();
            FILE.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Exam> findAll() {
        FileInputStream fileInputStream = null;
        List<Exam> exams = new ArrayList<>();
        try {
            if (FILE.length() != 0) {
                fileInputStream = new FileInputStream(PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ExamList examList = (ExamList) objectInputStream.readObject();
                exams = examList.getExams();
                objectInputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return exams;
    }

    public void addToFile(Exam exam) {
        FileOutputStream outputStream = null;
        List<Exam> exams = findAll();
        try {

            outputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            exams.add(exam);
            objectOutputStream.writeObject(new ExamList(exams));

            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
