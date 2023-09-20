package com.example.nimbus.service.custom;

import com.example.nimbus.dto.DepartmentDto;
import com.example.nimbus.service.SuperService;

import java.util.ArrayList;

public interface DepartmentService extends SuperService {
    ArrayList<DepartmentDto> getAllDepartments() throws Exception;
    DepartmentDto getDepartmentById(int id) throws Exception;
    int AddDepartment(DepartmentDto departmentDto) throws Exception;
    int updateDepartment(DepartmentDto departmentDto) throws Exception;
    int deleteDepartment(int i) throws Exception;
}
