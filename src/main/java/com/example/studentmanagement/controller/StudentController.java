package com.example.studentmanagement.controller;


import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/students/new")
    public String createStudentForm(Model model)
    {
        // create student object to hold student form data
        Student student=new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student)
    {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    //we are using path variable annotation to get the {id}
    //we need to bind this id to java variable, in order to that we are going to use @PathVariable
    public String editStudentFrom(@PathVariable Long id, Model model)
    {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,Model model)
    {
        //get student from database by id
        Student existingStudent=studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //save updated student object
        studentService.updateStudent(existingStudent);

        return "redirect:/students";

    }
}
