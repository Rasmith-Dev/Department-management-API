package com.example.departmentmanagment.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.departmentmanagement.error.DepartmentNotFoundException;
import com.example.departmentmanagment.entity.Department;
import com.example.departmentmanagment.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;

	@BeforeEach
	void setUp() throws Exception {
		department = new  Department(1L, "IT", "Hyd", "IT-01");	
	}

	@Test
	void testAdddepartment() throws Exception {
		//Department inputDepartment = new  Department("IT", "Hyd", "IT-01");
		
		Department inputDepartment = Department.builder().departmentName("IT")
				.departmentAddress("Hyd")
				.departmentCode("IT-01")
				.build();
		
		Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
		mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\r\n"
				+ "    \"departmentName\":\"IT\",\r\n"
				+ "    \"departmentAddress\":\"Hyd\",\r\n"
				+ "    \"departmentCode\":\"IT-01\"\r\n"
				+ "}")).andExpect(status().isOk());
	}

	@Test
	void testGetDepartmentById() throws Exception {
		Mockito.when(departmentService.getDepartmentById(1L)).thenReturn(department);
		mockMvc.perform(get("/departments/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
	}

}
