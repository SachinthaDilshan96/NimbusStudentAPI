package com.example.nimbus.dto.request;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentRequestDto {
    private String firstName;
    private String lastName;
    private Date birthDay;
    private int departmentId;
}
