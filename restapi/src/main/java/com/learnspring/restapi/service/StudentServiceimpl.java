package com.learnspring.restapi.service;

import com.learnspring.restapi.dto.StudentDto;
import com.learnspring.restapi.dto.addStudntRequestDto;
import com.learnspring.restapi.entity.Student;
import com.learnspring.restapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceimpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modalmapper;


    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map (student -> modalmapper.map(student , StudentDto.class))
                .toList();
    }
    public StudentDto getStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student not found with id : "+id));
        return modalmapper.map(student , StudentDto.class);
    }

    @Override
    public StudentDto createnewstudent(addStudntRequestDto addstudntrequestdto) {
        Student newStudent = modalmapper.map(addstudntrequestdto, Student.class);
    Student student = studentRepository.save(newStudent);
        return modalmapper.map(student , StudentDto.class);
    }

}
