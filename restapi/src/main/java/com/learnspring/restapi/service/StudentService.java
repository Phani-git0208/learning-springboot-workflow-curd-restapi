package com.learnspring.restapi.service;

import com.learnspring.restapi.dto.StudentDto;
import com.learnspring.restapi.dto.addStudntRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {

    List<StudentDto>getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createnewstudent(addStudntRequestDto addstudntrequestdto);

    void deletestudentbyid(Long id);

    StudentDto putstudentbyid(Long id, addStudntRequestDto addstudntrequestdto);

    StudentDto updatePartOfStudentById(Long id, Map<String, Object> updates);
}
