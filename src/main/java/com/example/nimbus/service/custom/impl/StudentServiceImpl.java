package com.example.nimbus.service.custom.impl;

import com.example.nimbus.dao.custom.DepartmentDao;
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
    @Autowired
    private DepartmentDao departmentDao;
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
                    studentEntity.getDepartment().getId()));
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
                    studentEntity.get().getDepartment().getId());
        }
        return studentDto;
    }

    @Override
    public StudentDto AddStudent(StudentDto studentDto) throws Exception {
        Optional<DepartmentEntity> department = departmentDao.findById(studentDto.getDepartmentId());
        if (department.isPresent()){
            StudentEntity studentEntity = new StudentEntity(
                    studentDto.getStudentId(),
                    studentDto.getFirstName(),
                    studentDto.getLastName(),
                    studentDto.getBirthDay(),
                    new DepartmentEntity(studentDto.getDepartmentId(),department.get().getDepartmentName()));
            StudentEntity result = studentDao.save(studentEntity);
            if (result!=null){
                return new StudentDto(
                        result.getStudentId(),
                        result.getFirstName(),
                        result.getLastName(),
                        result.getBirthDay(),
                        result.getDepartment().getId());
            }else {
                return null;
            }
        }
        return null;
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) throws Exception {
        Optional<StudentEntity> studentEntity = studentDao.findById(studentDto.getStudentId());
        if (studentEntity.isPresent()){
            DepartmentEntity departmentEntityToBeSaved = new DepartmentEntity(studentEntity.get().getDepartment().getId(),studentEntity.get().getDepartment().getDepartmentName());
            StudentEntity studentEntityToBeSaved = new StudentEntity(
                    studentDto.getStudentId(),
                    studentDto.getFirstName(),
                    studentDto.getLastName(),
                    studentDto.getBirthDay(),
                    departmentEntityToBeSaved);

            StudentEntity result = studentDao.save(studentEntityToBeSaved);
            if (result!=null){
                return new StudentDto(
                        result.getStudentId(),
                        result.getFirstName(),
                        result.getLastName(),
                        result.getBirthDay(),
                        result.getDepartment().getId());
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    @Override
    public String deleteStudent(int id) throws Exception {
        studentDao.deleteById(id);
        return "Student Deleted";
    }
}
