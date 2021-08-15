package com.example.demo.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo repo) {
        return args -> {
            Student Lighto = new Student(
                    "Lighto",
                    LocalDate.of(2000, APRIL,20),
                    "noor.abdelatif@gmail.com",
                    21
            );

            Student Som3a = new Student(
                    "Som3a",
                    LocalDate.of(2001, APRIL,22),
                    "noor.abdelatif@gmail.com",
                    21
            );

            repo.saveAll(
                    List.of(Lighto,Som3a)
            );

        };
    }
}
