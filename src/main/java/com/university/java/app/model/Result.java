package com.university.java.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class Result {

    private Exam exam;

    private double markScore;

    private String studentUserName;

    public Result(Exam exam, double markScore) {
        this.exam = exam;
        this.markScore = markScore;
    }
}
