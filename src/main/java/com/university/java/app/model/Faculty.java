package com.university.java.app.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Faculty implements Serializable {

    private String FacultyName;

    private List<Exam> exams;

    private double passingScore;

    public Faculty(String facultyName, List<Exam> exams, double passingScore) {
        FacultyName = facultyName;
        this.exams = exams;
        this.passingScore = passingScore;
    }
}
