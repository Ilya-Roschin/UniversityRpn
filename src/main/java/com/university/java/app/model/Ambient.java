package com.university.java.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ambient extends User{

    private String firstName;

    private String lastName;

    private List<Mark> Marks;
}
