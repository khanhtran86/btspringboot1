package com.samsung.demoprj.repositories;

import com.samsung.demoprj.repositories.models.Student;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{

    @Override
    public List<Student> getListOfStudents() {
        List<Student> lstStudents = new ArrayList<>();
        lstStudents.add(
                Student.builder()
                        .Name("Tùng Nguyễn")
                        .Email("tung.nguyen@gmail.com")
                        .Birthday(LocalDate.of(1990,05,11))
                        .Salary(5000000)
                        .build());
        lstStudents.add(
                Student.builder()
                        .Name("Hương Trần")
                        .Email("huong123@gmail.com")
                        .Birthday(LocalDate.of(1995, 05,25))
                        .Salary(7050000)
                        .Description("<i>Đây là giới thiệu về tôi</i><p><i><b>Tôi sinh ra ở một gia đình giàu có</b></i></p><p><img src='https://reqres.in/img/faces/7-image.jpg'/></p>")
                        .build());
        return lstStudents;
    }
}
