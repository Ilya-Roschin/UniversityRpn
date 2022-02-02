package com.university.java.app.repository;

import com.university.java.app.model.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultRepository {

    private static final List<Result> RESULTS = new ArrayList<>();

    public void addToRepository(Result result) {
        RESULTS.add(result);
    }

    public List<Result> findAll() {
        return RESULTS;
    }

    public List<Result> findAllByStudentName(String studentName) {
        return RESULTS.stream()
                .filter(result -> result.getStudentUserName().equals(studentName))
                .collect(Collectors.toList());
    }
}
