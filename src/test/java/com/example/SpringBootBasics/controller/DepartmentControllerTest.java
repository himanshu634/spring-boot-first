package com.example.SpringBootBasics.controller;

import com.example.SpringBootBasics.entity.Department;
import com.example.SpringBootBasics.exceptions.DepartmentNotFoundException;
import com.example.SpringBootBasics.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp(){
        department = Department.builder()
                .departmentId(1L)
                .departmentAddress("Ahmedabad")
                .departmentName("IT")
                .departmentCode("IT-06")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = department.builder()
                .departmentName("IT")
                .departmentCode("IT-06")
                .departmentAddress("Ahemdabad")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/save_department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"IT\",\n" +
                        "    \"departmentAddress\":\"Ahmedabad\",\n" +
                        "    \"departmentCode\":\"IT-06\"\n" +
                        "}")).andExpect(status().isOk());


    }

    @Test
    void getDepartment() throws Exception {
        Mockito.when(departmentService.getDepartment(1L))
                .thenReturn(department);

       mockMvc.perform(get("/department/1")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.departmentName")
                       .value(department.getDepartmentName()));
    }
}