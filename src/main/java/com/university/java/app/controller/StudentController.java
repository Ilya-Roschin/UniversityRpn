package com.university.java.app.controller;

import com.university.java.app.model.Exam;
import com.university.java.app.model.Faculty;
import com.university.java.app.model.Result;
import com.university.java.app.model.Student;
import com.university.java.app.repository.FacultyRepository;
import com.university.java.app.repository.StudentRepository;
import com.university.java.app.sign.StudentSign;
import com.university.java.app.status.StudentStatus;

import java.util.Scanner;

public class StudentController {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final FacultyRepository FACULTY_REPOSITORY = new FacultyRepository();
    private static final StudentRepository STUDENT_REPOSITORY = new StudentRepository();
    private static final StudentSign STUDENT_SIGN = new StudentSign();
    private static final Menu MENU = new Menu();

    public void readMenu() {
        // TODO: 01.02.2022 constant
        System.out.println("Student Menu \n " +
                "1. find all open faculty \n" +
                "2. enroll in a faculty \n" +
                "3. is student enroll \n" +
                "4. back");

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
                System.out.println("Enter Faculty name");
                String facultyName = SCANNER.nextLine();
                Faculty faculty = FACULTY_REPOSITORY.findByName(facultyName);


                for (Exam exam : faculty.getExams()) {
                    Result result = new Result();
                    result.setExam(exam);
                    result.setStudentUserName(STUDENT_SIGN.getLastUserName());
                }

                Student studentToUpdate = STUDENT_REPOSITORY.findByName(STUDENT_SIGN.getLastUserName());
                Student updatedStudent = studentToUpdate;
                updatedStudent.setStudentStatus(StudentStatus.WaitingForAResponse);
                updatedStudent.setSelectedForAdmissionFaculty(faculty);
                STUDENT_REPOSITORY.updateStudent(studentToUpdate, updatedStudent);
                break;
            case 3:
                StudentStatus studentStatus = STUDENT_REPOSITORY.findByName(STUDENT_SIGN.getLastUserName()).getStudentStatus();
                if (studentStatus == StudentStatus.Enlisted) {
                    System.out.println("congratulations on your admission to the faculty of" +
                            STUDENT_REPOSITORY.findByName(STUDENT_SIGN.getLastUserName()).getFaculty());
                } else if(studentStatus == StudentStatus.WaitingForAResponse ) {
                    System.out.println("wait for an answer");
                } else {
                    System.out.println("faculty not selected ");
                }
                break;
            case 4:
                MENU.readMainMenu();
                MENU.mainController();
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
