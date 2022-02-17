package com.university.java.app.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Result {

    private Exam exam;

    private double markScore;

    private String studentUserName;

    public Result(Exam exam, double markScore) {
        this.exam = exam;
        this.markScore = markScore;
    }
}
