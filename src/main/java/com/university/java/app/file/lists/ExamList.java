package com.university.java.app.file.lists;

import com.university.java.app.model.Exam;
import com.university.java.app.model.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ExamList implements Serializable {

    private List<Exam> exams = new ArrayList<>();

    public ExamList(List<Exam> exams) {
        this.exams = exams;
    }
}
