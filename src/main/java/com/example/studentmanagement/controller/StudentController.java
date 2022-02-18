package com.example.studentmanagement.controller;


import com.example.studentmanagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//the controller annotation indicates that this particular class serves the role of a controller
@Controller
public class StudentController {
    private StudentService studentService;

    //if spring bean has only one constructor we can omit autowired annotation
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //handler method to handle list students and return model and view
    @GetMapping("/students")
    public String listStudents(Model model)
    {

        model.addAttribute("students", studentService.getAllStudents());
        return "students";

    }
}
