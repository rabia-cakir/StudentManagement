package com.example.studentmanagement.service.impl;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import com.example.studentmanagement.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.List;

//we mark spring beans with service annotation to indicate that they are holding the business logic
@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    //If spring bean has only one constructor then @autowired annotation can be omitted
    //and spring will use that constructor and inject all necessary dependencies
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        //studentRepository provides all the crud methods
        //findAll() method returns a list of students
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
