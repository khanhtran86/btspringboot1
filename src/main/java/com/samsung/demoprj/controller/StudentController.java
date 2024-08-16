package com.samsung.demoprj.controller;

import com.samsung.demoprj.services.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    IStudentService studentService;
    public StudentController(IStudentService studentService)
    {
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public String ListStudent(Model model)
    {
        model.addAttribute("students", this.studentService.getStudents());
        return "students/Index";
    }
}
