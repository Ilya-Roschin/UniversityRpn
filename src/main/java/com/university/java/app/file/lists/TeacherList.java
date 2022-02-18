package com.university.java.app.file.lists;

import com.university.java.app.model.Student;
import com.university.java.app.model.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TeacherList implements Serializable {

    private List<Teacher> teachers = new ArrayList<>();

    public TeacherList(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
