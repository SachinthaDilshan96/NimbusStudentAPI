package com.example.nimbus;

import com.example.nimbus.dto.request.StudentRequestDto;
import com.example.nimbus.dto.response.StudentResponseDto;
import com.example.nimbus.entities.DepartmentEntity;
import com.example.nimbus.entities.StudentEntity;
import com.example.nimbus.util.mapper.StudentMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Date;

public class StudentMapperTest {

    @Test
    public void StudentEntityShouldMapToStudentResponseDto(){
        StudentEntity student = new StudentEntity(123,"FirstName","LastName",new Date(1999-12-12),new DepartmentEntity(1,"Department"));
        StudentResponseDto studentDto = StudentMapper.studentMapper.toStudentResponseDto(student);
        Assertions.assertNotNull(studentDto,"StudentResponseDto is not null");
    }

    @Test
    public void StudentRequestDtoShouldMapToStudentEntity(){
        StudentRequestDto studentRequestDto = new StudentRequestDto("FirstName","LastName",new Date(1999-12-12),1);
        StudentEntity student = StudentMapper.studentMapper.toStudentEntity(studentRequestDto);
        Assertions.assertNotNull(student,"StudentEntity is not null");
    }

}
