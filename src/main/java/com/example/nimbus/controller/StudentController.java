package com.example.nimbus.controller;
import com.example.nimbus.dto.StudentDto;
import com.example.nimbus.service.custom.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get_student/{id}")
    public String getStudent(@PathVariable Integer id) throws Exception {
        StudentDto studentDto = studentService.getStudentById(id);
        return studentDto.toString();
    }
    @PostMapping("/save_student")
    public StudentDto saveStudent(@RequestBody StudentDto studentDto) throws Exception {
        return studentService.AddStudent(studentDto);
    }
    @PutMapping("/update_student")
    public String updateStudent(){
        return "updated";
    }
    @DeleteMapping("/delete_student")
    public String deleteStudent(){
        return "deleete";
    }
}
