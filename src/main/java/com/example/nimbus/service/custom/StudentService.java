package com.example.nimbus.service.custom;
import com.example.nimbus.dto.request.StudentRequestDto;
import com.example.nimbus.dto.response.StudentResponseDto;
import com.example.nimbus.service.SuperService;

import java.util.List;

public interface StudentService extends SuperService {
    List<StudentResponseDto> getAllStudent() throws Exception;
    StudentResponseDto getStudentById(int id) throws Exception;
    StudentResponseDto AddStudent(StudentRequestDto studentDto) throws Exception;
    StudentResponseDto updateStudent(int id, StudentRequestDto studentDto) throws Exception;
    String deleteStudent(int id) throws Exception;
}
