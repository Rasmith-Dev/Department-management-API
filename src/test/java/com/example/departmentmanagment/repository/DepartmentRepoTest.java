package com.example.departmentmanagment.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.departmentmanagment.entity.Department;

@DataJpaTest
class DepartmentRepoTest {
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {
		//Department d = new Department("IT", "Hyderabad", "IT-01");
		Department d = Department.builder().departmentName("IT")
				.departmentAddress("Hyd")
				.departmentCode("IT-01")
				.build();
		entityManager.persist(d);
	}

	@Test
	public void whenFindById_GetDepartment() {
		Department department = departmentRepo.findById(1L).get();
		assertEquals(department.getDepartmentName(), "IT");
	}

}
