package com.university.java.app.sign;

import com.university.java.app.exception.IncorrectInputException;
import com.university.java.app.model.Student;
import com.university.java.app.model.User;
import com.university.java.app.repository.StudentRepository;
import com.university.java.app.status.StudentStatus;

import java.util.Scanner;

public class StudentSign {

    private static final StudentRepository STUDENT_REPOSITORY = new StudentRepository();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static String lastUserName;

    public boolean sign() throws IncorrectInputException {
        System.out.println("enter userName");
        String userName = SCANNER.nextLine();
        // TODO: 01.02.2022 обернуть в Optional
        User foundedUser = STUDENT_REPOSITORY.findByName(userName);
        System.out.println("enter password");
        String password = SCANNER.nextLine();

        if (isPassword(password, foundedUser)) {
            lastUserName = userName;
            return true;
        } else {
            System.out.println("User not found enter");
        }
        return false;
    }

    public void register() throws IncorrectInputException{
        System.out.println("enter userName");
        String userName = SCANNER.nextLine();
        System.out.println("enter password");
        String password = SCANNER.nextLine();

        STUDENT_REPOSITORY.addToRepository(new Student(userName, password, StudentStatus.Sleep));
    }

    private boolean isPassword(String password, User user) {
        return user.getPassword().equals(password);
    }

    public String getLastUserName() {
        return lastUserName;
    }
}
