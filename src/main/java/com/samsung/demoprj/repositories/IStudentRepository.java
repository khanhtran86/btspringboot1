package com.samsung.demoprj.repositories;

import com.samsung.demoprj.repositories.models.Student;

import java.util.List;

public interface IStudentRepository {
    public List<Student> getListOfStudents();
}
