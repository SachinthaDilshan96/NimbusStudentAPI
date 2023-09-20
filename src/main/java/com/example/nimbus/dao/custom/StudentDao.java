package com.example.nimbus.dao.custom;

import com.example.nimbus.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<StudentEntity,Integer> {
}
