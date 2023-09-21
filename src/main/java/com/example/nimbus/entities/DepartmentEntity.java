package com.example.nimbus.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "department")
public class DepartmentEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "department_name")
    private String departmentName;
    @OneToMany(mappedBy = "department",targetEntity = StudentEntity.class)
    private List<StudentEntity> studentEntities;

    public DepartmentEntity(int id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }
}
