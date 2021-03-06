package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // returns list of students
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    //Used to Add new resources to the system
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){

        studentService.addNewStudent(student);

    }
    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(@PathVariable ("studentID") Long studentID){
        studentService.deleteStudent(studentID);
    }

    @PutMapping(path = "{studentID}")
    public void updateStudent(@PathVariable("studentID") Long studentID,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email
                              ){

        studentService.updateStudent(studentID,name,email);

    }
}
