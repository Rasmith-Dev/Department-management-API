package com.example.departmentmanagment.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.departmentmanagement.error.DepartmentNotFoundException;
import com.example.departmentmanagment.entity.Department;
import com.example.departmentmanagment.repository.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepo.findAll();
	}

	@Override
	public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> dept = departmentRepo.findById(departmentId);
		if(!dept.isPresent()) {
			throw new DepartmentNotFoundException("Department is not found!!");
		}
		return dept.get();
	}

	@Override
	public Department getDepartmentByName(String departmentName) {
		return departmentRepo.findByDepartmentName(departmentName);
	}

	@Override
	public Department updateDepartmentById(Long departmentId, Department department) {

		Department depDB = departmentRepo.findById(departmentId).get();

		if (Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}

		if (Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}

		if (Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}

		return departmentRepo.save(depDB);
	}

	@Override
	public String deleteDepartmentById(Long departmentId) {
		if (departmentRepo.existsById(departmentId)) {
			departmentRepo.deleteById(departmentId);
			return "Successfully Deleted the department";
		} else {
			return "Sorry, You have provided a wrong id. there is no record found with the ID provided. Please check the id and try again";
		}
	}

}
