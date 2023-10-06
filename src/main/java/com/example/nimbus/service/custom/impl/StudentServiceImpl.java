package com.example.nimbus.service.custom.impl;

import com.example.nimbus.dao.custom.DepartmentDao;
import com.example.nimbus.dao.custom.StudentDao;
import com.example.nimbus.dto.request.StudentRequestDto;
import com.example.nimbus.dto.response.StudentResponseDto;
import com.example.nimbus.entities.DepartmentEntity;
import com.example.nimbus.entities.StudentEntity;
import com.example.nimbus.exceptions.EntryNotFoundException;
import com.example.nimbus.exceptions.EntrySavingFailedException;
import com.example.nimbus.exceptions.EntryUpdationFailedException;
import com.example.nimbus.service.custom.StudentService;
import com.example.nimbus.util.mapper.StudentMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<StudentResponseDto> getAllStudent() throws Exception {
        List<StudentEntity> studentEntities = studentDao.findAll();
        return StudentMapper.studentMapper.toStudentResponseDtos(studentEntities);
    }

    @Override
    public StudentResponseDto getStudentById(int id) throws Exception {
        Optional<StudentEntity> studentEntity = studentDao.findById(id);
        StudentResponseDto studentDto = null;
        if (studentEntity.isPresent()){
            return StudentMapper.studentMapper.toStudentResponseDto(studentEntity.get());
        }else{
            throw new EntryNotFoundException("Doctor not found");
        }
    }

    @Override
    public StudentResponseDto AddStudent(StudentRequestDto studentDto) throws Exception {
        Optional<DepartmentEntity> department = departmentDao.findById(studentDto.getDepartmentId());
        if (department.isPresent()){
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setFirstName(studentDto.getFirstName());
            studentEntity.setLastName(studentDto.getLastName());
            studentEntity.setBirthDay(studentDto.getBirthDay());
            studentEntity.setDepartment(new DepartmentEntity(studentDto.getDepartmentId(),department.get().getDepartmentName()));
            StudentEntity result = studentDao.save(studentEntity);
            if (result!=null){
                return StudentMapper.studentMapper.toStudentResponseDto(result);
            }else {
                throw new EntrySavingFailedException("Entry Saving Failed");
            }
        }
        return null;
    }

    @Override
    public StudentResponseDto updateStudent(int id,StudentRequestDto studentDto) throws Exception {
        Optional<StudentEntity> studentEntity = studentDao.findById(id);
        Optional<DepartmentEntity> departmentEntity = departmentDao.findById(studentDto.getDepartmentId());
        if (studentEntity.isPresent() & departmentEntity.isPresent()){
            DepartmentEntity departmentEntityToBeSaved = new DepartmentEntity(departmentEntity.get().getId(),departmentEntity.get().getDepartmentName());
            StudentEntity studentEntityToBeSaved = new StudentEntity(
                    id,
                    studentDto.getFirstName(),
                    studentDto.getLastName(),
                    studentDto.getBirthDay(),
                    departmentEntityToBeSaved);

            StudentEntity result = studentDao.save(studentEntityToBeSaved);
            if (result!=null){
                return StudentMapper.studentMapper.toStudentResponseDto(result);
            }else {
                throw new EntryUpdationFailedException("Student Update Failed");
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
