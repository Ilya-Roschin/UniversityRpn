package com.university.java.app.service;

import com.university.java.app.model.Exam;
import com.university.java.app.model.Faculty;
import com.university.java.app.model.Result;
import com.university.java.app.model.Student;
import com.university.java.app.repository.FacultyRepository;
import com.university.java.app.repository.StudentRepository;
import com.university.java.app.sign.StudentSign;
import com.university.java.app.status.StudentStatus;

import java.util.List;
import java.util.Scanner;

public class StudentService {

    private static final FacultyRepository FACULTY_REPOSITORY = new FacultyRepository();
    private static final StudentSign STUDENT_SIGN = new StudentSign();
    private static final StudentRepository STUDENT_REPOSITORY = new StudentRepository();
    private static final Scanner SCANNER = new Scanner(System.in);

    public void findAllOpenFaculty() {
        FACULTY_REPOSITORY.findAll().forEach(faculty -> {
                    System.out.print("faculty: " + faculty.getFacultyName()
                            + " passingScore: " + faculty.getPassingScore()
                            + " Exams: ");
                    faculty.getExams().forEach(exam -> System.out.print(exam.getExamName() + " "));
                    System.out.println();
                }
        );
    }

    public void enrolFaculty() {
        System.out.println("Enter Faculty name");
        String facultyName = SCANNER.nextLine();
        Faculty faculty = FACULTY_REPOSITORY.findByName(facultyName);

        for (Exam exam : faculty.getExams()) {
            Result result = new Result();
            result.setExam(exam);
            result.setStudentUserName(STUDENT_SIGN.getLastUserName());
        }

        Student student = STUDENT_REPOSITORY.findByName(STUDENT_SIGN.getLastUserName());
        Student studentToUpdate = new Student(student.getUserName(), student.getPassword(), student.getStudentStatus());
        studentToUpdate.setStudentStatus(StudentStatus.WaitingForAResponse);
        studentToUpdate.setSelectedForAdmissionFaculty(faculty);
        STUDENT_REPOSITORY.updateStudent(student.getUserName(), studentToUpdate);
    }

    public void userEnrollStatus() {
        StudentStatus studentStatus = STUDENT_REPOSITORY.findByName(STUDENT_SIGN.getLastUserName()).getStudentStatus();
        if (studentStatus == StudentStatus.Enlisted) {
            System.out.println("congratulations on your admission to the faculty of" +
                    STUDENT_REPOSITORY.findByName(STUDENT_SIGN.getLastUserName()).getFaculty());
        } else if (studentStatus == StudentStatus.WaitingForAResponse) {
            System.out.println("wait for an answer");
        } else {
            System.out.println("faculty not selected ");
        }
    }

    public void printResults() {
        Student student = STUDENT_REPOSITORY.findByName(STUDENT_SIGN.getLastUserName());
        StudentStatus studentStatus = student.getStudentStatus();
        if (studentStatus == StudentStatus.GetMark || studentStatus == StudentStatus.Enlisted) {
            List<Result> resultList = STUDENT_REPOSITORY.findByName(STUDENT_SIGN.getLastUserName()).getResults();

            for (Result result : resultList) {
                System.out.println("Exam: " + result.getExam().getExamName() + " Mark: " + result.getMarkScore());
            }

        } else if (studentStatus == StudentStatus.WaitingForAResponse) {
            System.out.println("WAIT RESPONSE !!!!");
        } else {
            System.out.println("CHOOSE FACULTY");
        }
    }
}
