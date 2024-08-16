package com.samsung.demoprj.services;

import com.samsung.demoprj.repositories.models.Student;

import java.util.List;

public interface IStudentService {
    public List<Student> getStudents();
}
