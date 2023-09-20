package com.example.nimbus.service.custom.impl;

import com.example.nimbus.dao.custom.DepartmentDao;
import com.example.nimbus.dao.custom.StudentDao;
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
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setFirstName(studentDto.getFirstName());
            studentEntity.setLastName(studentDto.getLastName());
            studentEntity.setBirthDay(studentDto.getBirthDay());
            studentEntity.setDepartment(new DepartmentEntity(studentDto.getDepartmentId(),department.get().getDepartmentName()));
            System.out.println("this is "+studentEntity);
            StudentEntity result = studentDao.save(studentEntity);
            System.out.println(result);
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
        Optional<DepartmentEntity> departmentEntity = departmentDao.findById(studentDto.getDepartmentId());
        if (studentEntity.isPresent() & departmentEntity.isPresent()){
            DepartmentEntity departmentEntityToBeSaved = new DepartmentEntity(departmentEntity.get().getId(),departmentEntity.get().getDepartmentName());
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
