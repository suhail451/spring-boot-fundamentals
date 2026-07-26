package com.filterPractice.filterPractice.GlobalException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFound.class)
        public ResponseEntity<String> handleStudentNotFound(StudentNotFound ex){

        return ResponseEntity.status(404).body(ex.getMessage());



    }
    @ExceptionHandler(NameAlreadyExist.class)
    public ResponseEntity<String> handleNameAlreadyExist(NameAlreadyExist ex){
        return ResponseEntity.status(403).body(ex.getMessage());

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(DuplicateUpdate.class)
    public ResponseEntity<String> handleDuplicate(DuplicateUpdate ex){
        return ResponseEntity.status(403).body(ex.getMessage());
    }

}
