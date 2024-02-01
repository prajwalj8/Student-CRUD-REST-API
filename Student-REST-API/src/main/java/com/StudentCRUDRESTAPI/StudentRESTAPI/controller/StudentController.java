package com.StudentCRUDRESTAPI.StudentRESTAPI.controller;


import com.StudentCRUDRESTAPI.StudentRESTAPI.exception.StudentNotFoundException;
import com.StudentCRUDRESTAPI.StudentRESTAPI.model.Student;
import com.StudentCRUDRESTAPI.StudentRESTAPI.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

//    injecting Student repositories using autowired
@Autowired
private StudentRepository studentRepository;


//Adding new Student
@PostMapping("/student")
@ResponseBody
    Student newStudent(@RequestBody Student newStudent) {
    return studentRepository.save(newStudent);
    }

//Fetching all students
@GetMapping("/all-information")
    List<Student> getAllTasks(){
        return studentRepository.findAll();
    }

//Fetching single student by id
    @GetMapping("/student/{id}")
    Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

//updating student by id
 @PutMapping("student/{id}")
    Student updateStudent (@RequestBody Student newStudent, @PathVariable Long id){
        return studentRepository.findById(id)
            .map(student->{
                student.setName(newStudent.getName());
                student.setSurname(newStudent.getSurname());
                student.setDegree(newStudent.getDegree());
                student.setCollege_name(newStudent.getCollege_name());
                student.setCity(newStudent.getCity());
                    return studentRepository.save(student);
            }).orElseThrow(()->new StudentNotFoundException(id));
    }

    //deleting student by id
    @DeleteMapping("/student/{id}")
    String deleteStudent(@PathVariable Long id){
        if(!studentRepository.existsById(id)){
            throw new StudentNotFoundException(id);
        }

        studentRepository.deleteById(id);
        return "Student Deleted Successfully";
    }

}
