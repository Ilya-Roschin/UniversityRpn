package com.university.java.app.file.lists;

import com.university.java.app.model.Faculty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FacultyList implements Serializable {

    private List<Faculty> faculties = new ArrayList<>();

    public FacultyList(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
