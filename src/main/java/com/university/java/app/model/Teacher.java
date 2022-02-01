package com.university.java.app.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Teacher extends User {

    public Teacher(String userName, String password) {
        super(userName, password);
    }
}
