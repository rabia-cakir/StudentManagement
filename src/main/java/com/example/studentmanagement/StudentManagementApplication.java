package com.example.studentmanagement;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }


    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void run(String... args) throws Exception {

      /*  Student student1=new Student("rabia","çakır", "rabiacakir@gmail.com");
        studentRepository.save(student1);

        Student student2=new Student("elif","çakır", "elifcakir@gmail.com");
        studentRepository.save(student2);

        Student student3=new Student("mine","çakır", "minecakir@gmail.com");
        studentRepository.save(student3);*/


    }
}
