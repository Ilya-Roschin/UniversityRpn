package com.university.java.app.service;

import com.university.java.app.model.Faculty;
import com.university.java.app.model.Result;
import com.university.java.app.model.Student;
import com.university.java.app.status.StudentStatus;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherService {

    public double addAverageMark(Student student) {

        List<Double> results = student.getResults().stream()
                .map(Result::getMarkScore)
                .collect(Collectors.toList());

        double markSum = 0;

        for (int i = 0; i < results.size(); i++) {
            markSum += results.get(i);
        }
        return markSum / results.size();
    }

    public boolean isStudentEnterTheFaculty(Student student) {
        return student.getAverageMark().orElseThrow(RuntimeException::new) >=
                student.getSelectedForAdmissionFaculty().getPassingScore();
    }

    public void autoUpdateStatus(Student student) {
        student.setStudentStatus(StudentStatus.Enlisted);
    }
}
