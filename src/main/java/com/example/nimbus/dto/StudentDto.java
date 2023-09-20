package com.example.nimbus.dto;


import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDto {
    private int studentId;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private DepartmentDto department;
}
