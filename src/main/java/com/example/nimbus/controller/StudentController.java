package com.example.nimbus.controller;
import com.example.nimbus.dto.StudentDto;
import com.example.nimbus.service.custom.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get_student/{id}")
    public StudentDto getStudent(@PathVariable Integer id) throws Exception {
        StudentDto studentDto = studentService.getStudentById(id);
        if (studentDto!=null)
            return studentDto;
        else return null;
    }

    @GetMapping("/get_all_students")
    public ArrayList<StudentDto> getAllStudents() throws Exception {
        ArrayList<StudentDto> students = studentService.getAllStudent();
        if (students.size()>0)
            return students;
        else return null;
    }

    @PostMapping("/save_student")
    public StudentDto saveStudent(@RequestBody StudentDto studentDto) throws Exception {
        System.out.println("this is studentDto"+studentDto);
        return studentService.AddStudent(studentDto);
    }
    @PutMapping("/update_student")
    public StudentDto updateStudent(@RequestBody StudentDto studentDto) throws Exception {
        return studentService.updateStudent(studentDto);
    }
    @DeleteMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable Integer id) throws Exception {
        return studentService.deleteStudent(id);
    }
}

