package com.university.java.app.model;

import com.university.java.app.status.StudentStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Student extends User{

    private StudentStatus studentStatus;

    private List<Result> results;

    public Student(String userName, String password, StudentStatus studentStatus) {
        super(userName, password);
        this.studentStatus = studentStatus;
    }

    public Student(String userName, String password, StudentStatus studentStatus, List<Result> marks) {
        super(userName, password);
        this.studentStatus = studentStatus;
        this.results = marks;
    }
}
