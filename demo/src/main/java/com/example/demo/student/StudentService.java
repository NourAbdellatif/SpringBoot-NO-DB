package com.example.demo.student;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Lighto",
                        LocalDate.of(2000, Month.APRIL,20),
                        "noor.abdelatif@gmail.com",
                        21
                )
        );
    }
}
