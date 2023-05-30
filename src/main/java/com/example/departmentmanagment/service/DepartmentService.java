package com.example.departmentmanagment.service;

import java.util.List;

import com.example.departmentmanagement.error.DepartmentNotFoundException;
import com.example.departmentmanagment.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> getAllDepartments();

	public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public Department getDepartmentByName(String departmentName);

	public Department updateDepartmentById(Long departmentId, Department department);

	public String deleteDepartmentById(Long departmentId);

}
