package com.university.java.app.service;

import com.university.java.app.model.Exam;
import com.university.java.app.model.Faculty;
import com.university.java.app.model.Result;
import com.university.java.app.model.Student;
import com.university.java.app.repository.FacultyRepository;
import com.university.java.app.repository.ResultRepository;
import com.university.java.app.repository.StudentRepository;
import com.university.java.app.status.StudentStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TeacherService {

    private static final FacultyRepository FACULTY_REPOSITORY = new FacultyRepository();
    private static final StudentRepository STUDENT_REPOSITORY = new StudentRepository();
    private static final ResultRepository RESULT_REPOSITORY = new ResultRepository();
    private static final TeacherService TEACHER_SERVICE = new TeacherService();
    private static final Scanner SCANNER = new Scanner(System.in);

    public void findAllFaculties() {
        FACULTY_REPOSITORY.findAll().forEach(faculty ->
                System.out.println("faculty: " + faculty.getFacultyName()
                        + "passingScore: " + faculty.getPassingScore()
                        + "Exams: " + faculty.getExams()));
    }

    public void findAllStudents() {
        STUDENT_REPOSITORY.findAll().forEach(student -> {
            System.out.print("student name: " + student.getUserName());
            boolean isMarkPresent = false;
            try {
                student.getAverageMark().isPresent();
                isMarkPresent = true;
            } catch (NullPointerException e) {

            }

            if(isMarkPresent) {
                System.out.println("mark: " + student.getAverageMark());
            } else {
                System.out.println();
            }

        });


    }

    public void findAllWaitingStudents() {
        STUDENT_REPOSITORY.findAll().stream()
                .filter(s -> s.getStudentStatus() == StudentStatus.WaitingForAResponse)
                .forEach(student -> System.out.println("student name: " + student.getUserName()));
    }

    public void addMarkToStudent() {
        System.out.println("enter Student name");
        String studentName = SCANNER.nextLine();

        Student chosenStudent = STUDENT_REPOSITORY.findByName(studentName);
        addResultsToStudent(chosenStudent);

        List<Result> results = chosenStudent.getResults();
        List<Result> updatedResults = new ArrayList<>();
        // List<Result> results = RESULT_REPOSITORY.findAllByStudentName(studentName);

        for (Result result : results) {
            System.out.println("enter " + studentName
                    + " mark for " + result.getExam().getExamName());
            double mark = SCANNER.nextDouble();
            result.setMarkScore(mark);
            updatedResults.add(result);
        }
        chosenStudent.setResults(updatedResults);

        TEACHER_SERVICE.addAverageMark(chosenStudent);
        chosenStudent.setStudentStatus(StudentStatus.GetMark);


        if (TEACHER_SERVICE.isStudentEnterTheFaculty(chosenStudent)) {
            TEACHER_SERVICE.autoUpdateStatus(chosenStudent);
        }
    }

    public void addAverageMark(Student student) {

        List<Double> results = student.getResults().stream()
                .map(Result::getMarkScore)
                .collect(Collectors.toList());

        double markSum = 0;

        for (int i = 0; i < results.size(); i++) {
            markSum += results.get(i);
        }
        student.setAverageMark(Optional.of(markSum / results.size()));
        student.setStudentStatus(StudentStatus.GetMark);
    }

    public boolean isStudentEnterTheFaculty(Student student) {
        return student.getAverageMark().orElseThrow(RuntimeException::new) >=
                student.getSelectedForAdmissionFaculty().getPassingScore();
    }

    public void autoUpdateStatus(Student student) {
        student.setFaculty(student.getSelectedForAdmissionFaculty());
        student.setStudentStatus(StudentStatus.Enlisted);
    }

    public void addResultsToStudent(Student student) {
        if (student.getStudentStatus() == StudentStatus.WaitingForAResponse) {
            System.out.println("Добавление результатов");
            Faculty facultyForAdmission = student.getSelectedForAdmissionFaculty();
            List<Exam> exams = facultyForAdmission.getExams();
            List<Result> results = new ArrayList<>();

            for (Exam exam : exams) {
                results.add(new Result(exam, 0));
                System.out.println("Добавлен результат");
            }
            student.setResults(results);
        } else {
            System.out.println("this student don't need result");
        }

    }
}
