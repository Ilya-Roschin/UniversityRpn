package com.university.java.app.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher extends User {

    public Teacher(String userName, String password) {
        super(userName, password);
    }
}
