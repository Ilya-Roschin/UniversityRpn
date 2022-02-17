package com.university.java.app.sign;

import com.university.java.app.model.Teacher;
import com.university.java.app.model.User;
import com.university.java.app.repository.TeacherRepository;
import lombok.Getter;

import java.util.Scanner;

@Getter
public class TeacherSing {

    private static final TeacherRepository TEACHER_REPOSITORY = new TeacherRepository();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static String lastUserName;

    public boolean sign() {
        System.out.println("enter userName");
        String userName = SCANNER.nextLine();
        User foundedUser = TEACHER_REPOSITORY.findByName(userName);
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

    public void register() {
        System.out.println("enter userName");
        String userName = SCANNER.nextLine();
        System.out.println("enter password");
        String password = SCANNER.nextLine();

        TEACHER_REPOSITORY.addToRepository(new Teacher(userName, password));
    }

    private boolean isPassword(String password, User user) {
        return user.getPassword().equals(password);
    }
}
