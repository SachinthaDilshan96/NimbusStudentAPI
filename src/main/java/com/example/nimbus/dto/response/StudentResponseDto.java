package com.example.nimbus.dto.response;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentResponseDto {
    private int studentId;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private int departmentId;
}
