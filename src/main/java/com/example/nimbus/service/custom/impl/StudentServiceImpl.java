package com.example.nimbus.service.custom.impl;

import com.example.nimbus.dao.custom.StudentDao;
import com.example.nimbus.dto.DepartmentDto;
import com.example.nimbus.dto.StudentDto;
import com.example.nimbus.entities.DepartmentEntity;
import com.example.nimbus.entities.StudentEntity;
import com.example.nimbus.service.custom.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public ArrayList<StudentDto> getAllStudent() throws Exception {
        List<StudentEntity> studentEntities = studentDao.findAll();
        ArrayList<StudentDto> studentDtos = new ArrayList<>();
        for (StudentEntity studentEntity:studentEntities){
            System.out.println(studentEntity);
            studentDtos.add(new StudentDto(
                    studentEntity.getStudentId(),
                    studentEntity.getFirstName(),
                    studentEntity.getLastName(),
                    studentEntity.getBirthDay(),
                    new DepartmentDto(studentEntity.getDepartment().getId(),studentEntity.getDepartment().getDepartmentName())
            ));
        }
        return studentDtos;
    }

    @Override
    public StudentDto getStudentById(int id) throws Exception {
        Optional<StudentEntity> studentEntity = studentDao.findById(id);
        StudentDto studentDto = null;
        if (studentEntity.isPresent()){
            studentDto = new StudentDto(
                    studentEntity.get().getStudentId(),
                    studentEntity.get().getFirstName(),
                    studentEntity.get().getLastName(),
                    studentEntity.get().getBirthDay(),
                    new DepartmentDto(studentEntity.get().getDepartment().getId(),studentEntity.get().getDepartment().getDepartmentName()));
        }
        return studentDto;
    }

    @Override
    public StudentDto AddStudent(StudentDto studentDto) throws Exception {
        StudentEntity studentEntity = new StudentEntity(
                studentDto.getStudentId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getBirthDay(),
                new DepartmentEntity(studentDto.getDepartment().getId(),studentDto.getDepartment().getDepartmentName()));
        StudentEntity result = studentDao.save(studentEntity);
        if (result!=null){
            return new StudentDto(
                    result.getStudentId(),
                    result.getFirstName(),
                    result.getLastName(),
                    result.getBirthDay(),
                    new DepartmentDto(result.getDepartment().getId(),result.getDepartment().getDepartmentName()));
        }else {
            return null;
        }
    }

    @Override
    public int updateStudent(StudentDto studentDto) throws Exception {
        return 0;
    }
}
