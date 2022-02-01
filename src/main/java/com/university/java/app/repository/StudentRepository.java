package com.university.java.app.repository;

import com.university.java.app.model.Student;
import com.university.java.app.model.User;
import com.university.java.app.status.StudentStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRepository {

    private static final List<Student> students = new ArrayList<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    public void addUser(Student student) {
        students.add(student);
    }

    public Student findByUsername(String name) {
        // TODO: 01.02.2022 create new exception
        return students.stream()
                .filter(u -> u.getUserName().equals(name))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public List<Student> findAll() {
        return students;
    }

    public boolean DeleteStudentByName(String username) {
        return students.remove(findByUsername(username));
    }

    public void updateStudentStatus(Student student, StudentStatus updatedStatus) {

    }

    public void updateStudent(Student student) {
        u
    }

    public void register() {

        System.out.println("enter userName");
        String userName = SCANNER.nextLine();
        System.out.println("enter password");
        String password = SCANNER.nextLine();
        System.out.println("enter lastName");

        addUser(new Student(userName,password, StudentStatus.Sleep));
    }

    public boolean signUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter userName");
        String userName = scanner.nextLine();
        // TODO: 01.02.2022 обернуть в Optional
        Student foundedStudent = findByUsername(userName);
        System.out.println("enter password");
        String password = scanner.nextLine();

        if (isPassword(password, foundedStudent)) {
            return true;
        } else {
            System.out.println("User not found enter");
        }
        return false;
    }

    private boolean isPassword(String password, Student student) {
        return student.getPassword().equals(password);
    }

}
