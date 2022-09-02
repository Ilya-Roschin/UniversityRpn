package com.university.java.app.util;

import com.university.java.app.exception.IncorrectInputException;
import com.university.java.app.model.Exam;
import com.university.java.app.model.Faculty;
import com.university.java.app.model.Student;
import com.university.java.app.model.Teacher;
import com.university.java.app.repository.ExamRepository;
import com.university.java.app.repository.FacultyRepository;
import com.university.java.app.repository.StudentRepository;
import com.university.java.app.repository.TeacherRepository;
import com.university.java.app.status.StudentStatus;

import java.util.ArrayList;
import java.util.List;

public class Initialisation {

    public void init() throws IncorrectInputException {

        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addToRepository(new Student("ivan","123", StudentStatus.Sleep));
        studentRepository.addToRepository(new Student("andrey","123", StudentStatus.Sleep));
        studentRepository.addToRepository(new Student("vladislav","123", StudentStatus.Sleep));

        TeacherRepository teacherRepository = new TeacherRepository();
        teacherRepository.addToRepository(new Teacher("grib","123"));
        teacherRepository.addToRepository(new Teacher("roflich","123"));
        teacherRepository.addToRepository(new Teacher("login","123"));

        ExamRepository examRepository = new ExamRepository();
        Exam physics = new Exam("physics");
        examRepository.addToRepository(physics);
        Exam math = new Exam("math");
        examRepository.addToRepository(math);
        Exam rpn = new Exam("rpn");
        examRepository.addToRepository(rpn);

        List<Exam> list1 = new ArrayList<>();
        List<Exam> list2 = new ArrayList<>();

        list1.add(physics);
        list1.add(math);

        list2.add(rpn);
        list2.add(math);

        FacultyRepository facultyRepository = new FacultyRepository();
        facultyRepository.addToRepository(new Faculty("FCP",list2,6d));
        facultyRepository.addToRepository(new Faculty("REF",list1,4d));

    }
}
