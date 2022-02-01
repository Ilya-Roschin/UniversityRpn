package com.university.java.app.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    protected String userName;

    protected String password;
}
