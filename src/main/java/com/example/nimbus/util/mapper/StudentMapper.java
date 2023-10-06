package com.example.nimbus.util.mapper;

import com.example.nimbus.dto.request.StudentRequestDto;
import com.example.nimbus.dto.response.StudentResponseDto;
import com.example.nimbus.entities.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);

    StudentResponseDto toStudentResponseDto(StudentEntity student);
    StudentEntity toStudentEntity(StudentRequestDto student);
    List<StudentResponseDto> toStudentResponseDtos(List<StudentEntity> studentEntities);

}
