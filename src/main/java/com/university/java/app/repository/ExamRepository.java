package com.university.java.app.repository;

import com.university.java.app.file.fileReader.ExamFileReader;
import com.university.java.app.model.Exam;

public class ExamRepository {

    private static final ExamFileReader EXAM_FILE_READER = new ExamFileReader();

    public void addToRepository(Exam exam) {
        EXAM_FILE_READER.addToFile(exam);
    }

}
