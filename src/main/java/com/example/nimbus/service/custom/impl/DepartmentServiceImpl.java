package com.example.nimbus.service.custom.impl;

import com.example.nimbus.dao.custom.DepartmentDao;
import com.example.nimbus.dto.DepartmentDto;
import com.example.nimbus.entities.DepartmentEntity;
import com.example.nimbus.service.custom.DepartmentService;

import java.util.ArrayList;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;
    @Override
    public ArrayList<DepartmentDto> getAllDepartments() throws Exception {
        return null;
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
        return 0;
    }

    @Override
    public int updateDepartment(DepartmentDto departmentDto) throws Exception {
        return 0;
    }
}
