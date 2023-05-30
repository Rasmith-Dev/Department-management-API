package com.example.departmentmanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.departmentmanagment.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

	boolean existsById(Long id);

	Department findByDepartmentName(String departmentName);
}
