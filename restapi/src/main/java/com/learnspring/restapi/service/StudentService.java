package com.learnspring.restapi.service;

import com.learnspring.restapi.dto.StudentDto;
import com.learnspring.restapi.dto.addStudntRequestDto;

import java.util.List;

public interface StudentService {

    List<StudentDto>getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createnewstudent(addStudntRequestDto addstudntrequestdto);
}
