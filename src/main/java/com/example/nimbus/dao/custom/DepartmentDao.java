package com.example.nimbus.dao.custom;

import com.example.nimbus.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<DepartmentEntity,Integer> {
}
