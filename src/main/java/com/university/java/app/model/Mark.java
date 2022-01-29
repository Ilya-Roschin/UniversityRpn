package com.university.java.app.model;

import com.university.java.app.exam.Exam;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Mark {

    private double markScore;

    private Exam exam;
}
