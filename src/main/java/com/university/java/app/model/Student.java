package com.university.java.app.model;

import com.university.java.app.status.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class Student extends User {

    private StudentStatus studentStatus;

    private List<Result> results;

    private Faculty faculty;

    private Faculty selectedForAdmissionFaculty;

    private Optional<Double> averageMark;

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
