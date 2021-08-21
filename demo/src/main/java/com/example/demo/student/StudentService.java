package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private final StudentRepo studentRepo;


    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    public void addNewStudent(Student student) {
        //Business Logic
        Optional <Student> studentOptional=studentRepo.
                findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepo.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentID) {
        studentRepo.findById(studentID);
        boolean exists = studentRepo.existsById(studentID);
        if(!exists){
            throw new IllegalStateException("Student does not exist with ID" + studentID);
        }
        studentRepo.deleteById(studentID);
    }

    @Transactional//Entity goes into manage state
    public void updateStudent(Long id, String name, String email) {

        Student student=studentRepo.findById(id).
                orElseThrow(()->new IllegalStateException("student with id "+ id+" does not exist"));

        if(name!=null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional=studentRepo.findStudentByEmail(email);

            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }

}
