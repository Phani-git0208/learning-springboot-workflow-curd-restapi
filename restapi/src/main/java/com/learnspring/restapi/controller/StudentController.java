package com.learnspring.restapi.controller;

import com.learnspring.restapi.dto.StudentDto;
import com.learnspring.restapi.dto.addStudntRequestDto;
import com.learnspring.restapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;
import java.util.Map;

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
    public ResponseEntity<StudentDto> createnewstudent(@RequestBody @Valid addStudntRequestDto addstudntrequestdto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createnewstudent(addstudntrequestdto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
        studentService.deletestudentbyid(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> putStudentById(@PathVariable Long id,
                                                     @RequestBody addStudntRequestDto addstudntrequestdto){
        return ResponseEntity.ok(studentService.putstudentbyid(id , addstudntrequestdto));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartOfStudentById(@PathVariable Long id,
                                                     @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentService.updatePartOfStudentById(id , updates));
    }

}

