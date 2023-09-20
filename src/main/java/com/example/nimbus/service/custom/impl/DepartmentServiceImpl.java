package com.example.nimbus.service.custom.impl;

import com.example.nimbus.dao.custom.DepartmentDao;
import com.example.nimbus.dto.DepartmentDto;
import com.example.nimbus.dto.StudentDto;
import com.example.nimbus.entities.DepartmentEntity;
import com.example.nimbus.service.custom.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public ArrayList<DepartmentDto> getAllDepartments() throws Exception {
        List<DepartmentEntity> departmentEntities = departmentDao.findAll();
        ArrayList<DepartmentDto> departmentDtos = new ArrayList<>();
        for (DepartmentEntity departmentEntity:departmentEntities){
            departmentDtos.add(new DepartmentDto(departmentEntity.getId(),departmentEntity.getDepartmentName()));
        }
        return departmentDtos;
    }

    @Override
    public DepartmentDto getDepartmentById(int id) throws Exception {
        Optional<DepartmentEntity> department = departmentDao.findById(id);
        if (department.isPresent()){
            DepartmentEntity departmentEntity = department.get();
            return new DepartmentDto(departmentEntity.getId(),departmentEntity.getDepartmentName());
        }else {
            return null;
        }
    }

    @Override
    public int AddDepartment(DepartmentDto departmentDto) throws Exception {
        DepartmentEntity departmentEntity = departmentDao.save(new DepartmentEntity(departmentDto.getId(),departmentDto.getDepartmentName()));
        if (departmentEntity!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public int updateDepartment(DepartmentDto departmentDto) throws Exception {
        Optional<DepartmentEntity> departmentEntity = departmentDao.findById(departmentDto.getId());
        if (departmentEntity.isPresent()){
           DepartmentEntity department = departmentDao.save(new DepartmentEntity(departmentEntity.get().getId(),departmentEntity.get().getDepartmentName()));
           if (department!=null){
               return 1;
           }else{
               return -1;
           }
        }
        return 0;
    }

    @Override
    public int deleteDepartment(int i) throws Exception {
        departmentDao.deleteById(i);
        return 1;
    }


}
