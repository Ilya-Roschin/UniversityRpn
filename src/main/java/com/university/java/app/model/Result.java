package com.university.java.app.model;

import com.university.java.app.exam.Exam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {

    private Exam exam;

    private double markScore;

    private String studentUserName;
}
