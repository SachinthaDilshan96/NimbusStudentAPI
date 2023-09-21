package com.example.nimbus.controller;

import com.example.nimbus.dto.DepartmentDto;
import com.example.nimbus.service.custom.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/department")
@CrossOrigin
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/get_department/{id}")
    public DepartmentDto getDepartment(@PathVariable Integer id) throws Exception {
        DepartmentDto departmentDto = departmentService.getDepartmentById(id);
        if (departmentDto!=null)
            return departmentDto;
        else return null;
    }

    @GetMapping("/get_all_departments")
    public ArrayList<DepartmentDto> getAllDepartments() throws Exception {
        ArrayList<DepartmentDto> departmentDtos = departmentService.getAllDepartments();
        if (departmentDtos.size()>0)
            return departmentDtos;
        else return null;
    }

    @PostMapping("/save_department")
    public String saveStudent(@RequestBody DepartmentDto departmentDto) throws Exception {
       int i = departmentService.AddDepartment(departmentDto);
       if (i>0){
           return "Department Saved";
       }else {
           return "Department saving failed";
       }
    }
    @PutMapping("/update_department")
    public String updateDepartment(@RequestBody DepartmentDto departmentDto) throws Exception {
        int i = departmentService.updateDepartment(departmentDto);
        if (i>0){
            return "Department Updated";
        }else {
            return "Department update failed";
        }
    }
    @DeleteMapping("/delete_department/{id}")
    public String deleteDepartment(@PathVariable Integer id) throws Exception {
        if (departmentService.deleteDepartment(id)>0){
            return "Department Deleted";
        }else {
            return "Department deletion failed";
        }
    }
}
