package com.samsung.demoprj.services;

import com.samsung.demoprj.repositories.IStudentRepository;
import com.samsung.demoprj.repositories.models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    IStudentRepository studentRepo;
    public StudentService(IStudentRepository studentRepo)
    {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getStudents() {
        return this.studentRepo.getListOfStudents();
    }
}
