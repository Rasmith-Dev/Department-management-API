package com.example.departmentmanagment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.departmentmanagement.error.DepartmentNotFoundException;
import com.example.departmentmanagment.entity.Department;
import com.example.departmentmanagment.repository.DepartmentRepo;
import com.example.departmentmanagment.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/departments")
	public Department adddepartment(@Valid @RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		return departmentService.getDepartmentById(departmentId);
	}

	@GetMapping("/departments/name/{name}")
	public Department getDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.getDepartmentByName(departmentName);
	}

	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long departmentId,
			@Valid @RequestBody Department department) {
		return departmentService.updateDepartmentById(departmentId, department);

	}

	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		return departmentService.deleteDepartmentById(departmentId);
	}

}
