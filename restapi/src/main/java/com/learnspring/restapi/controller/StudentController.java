package com.learnspring.restapi.controller;

import com.learnspring.restapi.dto.StudentDto;
import com.learnspring.restapi.dto.addStudntRequestDto;
import com.learnspring.restapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudent() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("")
    public ResponseEntity<StudentDto> createnewstudent(@RequestBody addStudntRequestDto addstudntrequestdto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createnewstudent(addstudntrequestdto));
    }


}

