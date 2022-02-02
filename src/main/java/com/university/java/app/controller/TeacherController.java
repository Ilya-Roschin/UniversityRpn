package com.university.java.app.controller;

import com.university.java.app.model.Result;
import com.university.java.app.model.Student;
import com.university.java.app.repository.FacultyRepository;
import com.university.java.app.repository.ResultRepository;
import com.university.java.app.repository.StudentRepository;
import com.university.java.app.service.TeacherService;
import com.university.java.app.status.StudentStatus;

import java.util.List;
import java.util.Scanner;

public class TeacherController {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final FacultyRepository FACULTY_REPOSITORY = new FacultyRepository();
    private static final StudentRepository STUDENT_REPOSITORY = new StudentRepository();
    private static final ResultRepository RESULT_REPOSITORY = new ResultRepository();
    private static final TeacherService TEACHER_SERVICE = new TeacherService();
    private static final Menu MENU = new Menu();


    public void readMenu() {
        // TODO: 01.02.2022 constant
        System.out.println("Student Menu \n " +
                "1. find all faculty \n" +
                "2. find all students" + "\n" +
                "3. find all waiting students" + "\n" +
                "4. add mark for students" + "\n" +
                "5. back");
    }

    public void mainController() {
        switch (choose()) {
            case 1:
                FACULTY_REPOSITORY.findAll().forEach(faculty ->
                        System.out.println("faculty: " + faculty.getFacultyName()
                                + "passingScore: " + faculty.getPassingScore()
                                + "Exams: " + faculty.getExams()));
                break;
            case 2:
                STUDENT_REPOSITORY.findAll().forEach(student ->
                        System.out.println("student name: " + student.getUserName()));
                break;
            case 3:
                STUDENT_REPOSITORY.findAll().stream()
                        .filter(s -> s.getStudentStatus() == StudentStatus.WaitingForAResponse)
                        .forEach(student -> System.out.println("student name: " + student.getUserName()));
                break;

            case 4:
                System.out.println("enter Student name");
                String studentName = SCANNER.nextLine();
                Student chosenStudent = STUDENT_REPOSITORY.findByName(studentName);

                List<Result> results = RESULT_REPOSITORY.findAllByStudentName(studentName);

                for (Result result : results) {
                    System.out.println("enter " + result.getStudentUserName()
                            + " mark for " + result.getExam().getExamName());
                    double mark = SCANNER.nextDouble();
                    result.setMarkScore(mark);
                }

                TEACHER_SERVICE.addAverageMark(chosenStudent);

                if (TEACHER_SERVICE.isStudentEnterTheFaculty(chosenStudent)) {
                    TEACHER_SERVICE.autoUpdateStatus(chosenStudent);
                }

                break;
            default:
                System.out.println("Incorrect input!!! Try again");
        }
        readMenu();
        mainController();
    }


    private int choose() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
