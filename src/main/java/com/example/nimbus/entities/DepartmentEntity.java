package com.example.nimbus.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "department")
public class DepartmentEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "department_name")
    private String departmentName;
}
