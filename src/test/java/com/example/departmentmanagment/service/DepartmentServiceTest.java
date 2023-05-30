package com.example.departmentmanagment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.departmentmanagement.error.DepartmentNotFoundException;
import com.example.departmentmanagment.entity.Department;
import com.example.departmentmanagment.repository.DepartmentRepo;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;

	@MockBean
	private DepartmentRepo departmentRepo;

	@BeforeEach
	void setUp() throws Exception {
		//Department d = new Department(1L, "IT", "Hyd", "IT-01");
		Department d = Department.builder().departmentName("IT")
				.departmentAddress("Hyd")
				.departmentCode("IT-01").departmentId(1L)
				.build();

		Mockito.when(departmentRepo.findByDepartmentName("IT")).thenReturn(d);
		Mockito.when(departmentRepo.findByDepartmentName("a")).thenReturn(d);
		//Mockito.when(departmentRepo.findById(1L).get()).thenReturn(d);
	}

	@Test
	@DisplayName("get department based on a valid Department Name")
	//@Disabled this annotation is used to disable or skip this particular method or test case when the whole app is running
	public void whenVaildName_GetTheDepartment() {
		String departmentName = "IT";
		Department found = departmentService.getDepartmentByName(departmentName);
		assertEquals(departmentName, found.getDepartmentName());
	}

	
	  @Test 
	  public void whenInvaildName_DontGetTheDepartment() { String
	  departmentName = "a"; 
	  Department found = departmentService.getDepartmentByName(departmentName);
	  assertNotEquals(departmentName, found.getDepartmentName()); }
	
	/*
	 * @Test public void whenVaildID_GetTheDepartment() throws
	 * DepartmentNotFoundException { Long departmentId = 1L; Department found =
	 * departmentService.getDepartmentById(departmentId); assertEquals("Hyd",
	 * found.getDepartmentName()); }
	 */
}
