package com.example.nimbus.dto;

import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DepartmentDto {
    private int id;
    private String departmentName;
}
