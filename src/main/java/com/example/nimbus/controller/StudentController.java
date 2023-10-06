package com.example.nimbus.controller;
import com.example.nimbus.dto.request.StudentRequestDto;
import com.example.nimbus.dto.response.StudentResponseDto;
import com.example.nimbus.service.custom.StudentService;
import com.example.nimbus.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getStudent(@PathVariable Integer id) throws Exception {
        StudentResponseDto studentDto = studentService.getStudentById(id);
        if (studentDto!=null)
            return new ResponseEntity<>(new StandardResponse(200,"Student Data",studentDto), HttpStatus.OK);
        else return new ResponseEntity<>( new StandardResponse(204,"Student Not Found",null), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get_all_students")
    public ResponseEntity<StandardResponse> getAllStudents() throws Exception {
        List<StudentResponseDto> students = studentService.getAllStudent();
        if (students.size()>0)
            return new ResponseEntity<>(new StandardResponse(200,"Student Details",students),HttpStatus.OK);
        else return new ResponseEntity<>(new StandardResponse(204,"No Students to show",null),HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<StandardResponse> saveStudent(@RequestBody StudentRequestDto studentDto) throws Exception {
        StudentResponseDto studentResult = studentService.AddStudent(studentDto);
        if (studentResult!=null)
            return new ResponseEntity<>(new StandardResponse(201,"Student Saved",studentResult),HttpStatus.OK);
        else
            return new ResponseEntity<>(new StandardResponse(204,"Student Saving Failed", null),HttpStatus.OK);
    }
    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateStudent(@RequestParam int id,@RequestBody StudentRequestDto studentDto) throws Exception {
        StudentResponseDto studentResult = studentService.updateStudent(id,studentDto);
        if (studentResult!=null)
            return new ResponseEntity<>(new StandardResponse(201,"Student Updated",studentResult),HttpStatus.OK);
        else
            return new ResponseEntity<>(new StandardResponse(204,"Student Couldn't be updated",null),HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteStudent(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(new StandardResponse(200,"Student Deleted",studentService.deleteStudent(id)),HttpStatus.OK);
    }
}

