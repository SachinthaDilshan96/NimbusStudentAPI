package com.example.nimbus.controller;
import com.example.nimbus.dto.StudentDto;
import com.example.nimbus.service.custom.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get_student/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Integer id) throws Exception {
        StudentDto studentDto = studentService.getStudentById(id);
        if (studentDto!=null)
            return new ResponseEntity<>(studentDto, HttpStatus.OK);
        else return new ResponseEntity<>( null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get_all_students")
    public ResponseEntity<ArrayList<StudentDto>> getAllStudents() throws Exception {
        ArrayList<StudentDto> students = studentService.getAllStudent();
        if (students.size()>0)
            return new ResponseEntity<>(students,HttpStatus.OK);
        else return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @PostMapping("/save_student")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto) throws Exception {
        StudentDto studentResult = studentService.AddStudent(studentDto);
        if (studentResult!=null)
            return new ResponseEntity<>(studentResult,HttpStatus.OK);
        else
            return new ResponseEntity<>(studentResult,HttpStatus.NO_CONTENT);
    }
    @PutMapping("/update_student")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto) throws Exception {
        StudentDto studentResult = studentService.updateStudent(studentDto);
        if (studentResult!=null)
            return new ResponseEntity<>(studentResult,HttpStatus.OK);
        else
            return new ResponseEntity<>(studentResult,HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(studentService.deleteStudent(id),HttpStatus.OK);
    }
}

