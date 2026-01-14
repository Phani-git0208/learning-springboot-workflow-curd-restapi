package com.learnspring.restapi.service;

import com.learnspring.restapi.dto.StudentDto;
import com.learnspring.restapi.dto.addStudntRequestDto;
import com.learnspring.restapi.entity.Student;
import com.learnspring.restapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public void deletestudentbyid(Long id){
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("student not found with id : "+id);
        }
        studentRepository.deleteById(id);
    }
    @Override
    public StudentDto putstudentbyid(Long id,addStudntRequestDto addstudntrequestdto){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("student not found with id : "+id));
        modalmapper.map(addstudntrequestdto,student);

        student = studentRepository.save(student);
        return modalmapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartOfStudentById(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("student not found with id : "+id));
        updates.forEach((String field, Object value) -> {
            switch(field){
                case "name":student.setName((String)value);
                break;
                case "email":student.setEmail((String)value);
                    break;
                case "marks": student.setMarks((int)value);
                    break;
                default :
                    throw new IllegalArgumentException("invalid entry");
            }
        });
        Student savedstudent= studentRepository.save(student);
        return modalmapper.map(student, StudentDto.class);
    }
}
