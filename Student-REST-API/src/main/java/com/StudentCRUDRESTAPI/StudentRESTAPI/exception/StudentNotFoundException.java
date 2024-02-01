package com.StudentCRUDRESTAPI.StudentRESTAPI.exception;

public class StudentNotFoundException extends RuntimeException{

public StudentNotFoundException(Long id){
    super("Student Not Found!");
}

}
