package com.university.java.app.controller;

import com.university.java.app.sign.StudentSign;
import com.university.java.app.sign.TeacherSing;

import java.util.Scanner;

public class Menu {

    private static final StudentSign STUDENT_SIGN = new StudentSign();
    private static final TeacherSing TEACHER_SING = new TeacherSing();
    private static final Scanner SCANNER = new Scanner(System.in);

    public void readMainMenu() {
        // TODO: 01.02.2022 constant
        System.out.println("Menu \n" +
                "1. Student \n" +
                "2. Teacher \n");
    }

    public void mainController() {
        switch (choose()) {
            case 1:
                readStudentMenu();
                studentController();
                break;
            case 2:
                readTeacherMenu();
                teacherController();
                break;
            default:
                System.out.println("Incorrect input!!!");
        }
        readMainMenu();
        mainController();
    }

    public void readStudentMenu() {
        // TODO: 01.02.2022 constant
        System.out.println("Student Menu \n" +
                "1. sign \n" +
                "2. reg \n" +
                "3. back");
    }

    public void studentController() {
        switch (choose()) {
            case 1:
                if (STUDENT_SIGN.sign()) {
                    StudentController studentController = new StudentController();
                    studentController.readMenu();
                    studentController.mainController();
                } else {
                    System.out.println("Incorrect input!!!");
                }
                break;
            case 2:
                STUDENT_SIGN.register();
                readStudentMenu();
                studentController();
                break;
            case 3:
                break;
            default:
                System.out.println("Incorrect input!!!");
        }
        readMainMenu();
        mainController();
    }

    public void readTeacherMenu() {
        // TODO: 01.02.2022 constant
        System.out.println("Teacher Menu \n" +
                "1. sign \n" +
                "2. reg \n" +
                "3. back");
    }

    public void teacherController() {
        switch (choose()) {
            case 1:
                if (TEACHER_SING.sign()) {
                    TeacherController teacherController = new TeacherController();
                    teacherController.readMenu();
                    teacherController.mainController();
                } else {
                    System.out.println("Incorrect input!!!");
                }
                break;
            case 2:
                TEACHER_SING.register();
                readTeacherMenu();
                teacherController();
                break;
            case 3:
                break;
            default:
                System.out.println("Incorrect input!!!");
        }
        readMainMenu();
        mainController();
    }

    private int choose() {
        return SCANNER.nextInt();
    }
}
