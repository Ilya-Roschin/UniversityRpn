package com.university.java.app.controller;

import com.university.java.app.service.StudentService;

import java.util.Scanner;

public class StudentController {

    private static final StudentService STUDENT_SERVICE = new StudentService();
    private static final Menu MENU = new Menu();

    public void readMenu() {
        // TODO: 01.02.2022 constant
        System.out.println("Student Menu \n" +
                "1. find all open faculty \n" +
                "2. enroll in a faculty \n" +
                "3. is student enroll \n" +
                "4. back");
    }

    public void mainController() {
        switch (choose()) {
            case 1:
                STUDENT_SERVICE.findAllOpenFaculty();
                break;
            case 2:
                STUDENT_SERVICE.enrolFaculty();
                break;
            case 3:
                STUDENT_SERVICE.userEnrollStatus();
                break;
            case 4:
                MENU.readMainMenu();
                MENU.mainController();
                break;
            case 5:
                // TODO: 15.02.2022 get mark
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
