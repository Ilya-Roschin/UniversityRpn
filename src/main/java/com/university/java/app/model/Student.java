package com.university.java.app.model;

import com.university.java.app.status.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student extends User implements Serializable, Cloneable {

    private StudentStatus studentStatus;

    private List<Result> results = new ArrayList<>();

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
