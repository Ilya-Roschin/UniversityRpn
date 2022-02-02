package com.university.java.app.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Faculty {

    private String FacultyName;

    private List<Exam> exams;

    private double passingScore;

    public Faculty(String facultyName, List<Exam> exams, double passingScore) {
        FacultyName = facultyName;
        this.exams = exams;
        this.passingScore = passingScore;
    }
}
