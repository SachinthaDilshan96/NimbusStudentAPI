package com.example.nimbus.service.custom;

import com.example.nimbus.dto.StudentDto;
import com.example.nimbus.service.SuperService;

import java.util.ArrayList;

public interface StudentService extends SuperService {
    ArrayList<StudentDto> getAllStudent() throws Exception;
    StudentDto getStudentById(int id) throws Exception;
    StudentDto AddStudent(StudentDto studentDto) throws Exception;
    StudentDto updateStudent(StudentDto studentDto) throws Exception;
    String deleteStudent(int id) throws Exception;
}
