package com.university.java.app.repository;

import com.university.java.app.model.Exam;

import java.util.ArrayList;
import java.util.List;

public class ExamRepository {

    private static final List<Exam> EXAMS = new ArrayList<>();

    public void addToRepository(Exam exam) {
        EXAMS.add(exam);
    }

    public List<Exam> findAll() {
        return EXAMS;
    }
}
