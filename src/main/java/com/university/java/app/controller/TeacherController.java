package com.university.java.app.controller;

import com.university.java.app.service.TeacherService;

import java.util.Scanner;

public class TeacherController {

    private static final TeacherService TEACHER_SERVICE = new TeacherService();
    private static final Menu MENU = new Menu();

    public void readMenu() {
        // TODO: 01.02.2022 constant
        System.out.println("Student Menu \n" +
                "1. find all faculty \n" +
                "2. find all students" + "\n" +
                "3. find all waiting students" + "\n" +
                "4. add mark for students" + "\n" +
                "5. back");
    }

    public void mainController() {
        switch (choose()) {
            case 1:
                TEACHER_SERVICE.findAllFaculties();
                break;
            case 2:
                TEACHER_SERVICE.findAllStudents();
                break;
            case 3:
                TEACHER_SERVICE.findAllWaitingStudents();
                break;
            case 4:
                TEACHER_SERVICE.addMarkToStudent();
                break;
            case 5:
                MENU.readMainMenu();
                MENU.mainController();
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
