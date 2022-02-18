package com.university.java.app.file.lists;

import com.university.java.app.model.Student;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudentList implements Serializable {

    private List<Student> students = new ArrayList<>();

    public StudentList(List<Student> students) {
        this.students = students;
    }
}
