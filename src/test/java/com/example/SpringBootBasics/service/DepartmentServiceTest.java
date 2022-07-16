package com.example.SpringBootBasics.service;

import com.example.SpringBootBasics.entity.Department;
import com.example.SpringBootBasics.repository.DepartmentRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean // Used to mock particular class here in this case departmentRepository object is being mocked.
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                .departmentId(1L)
                .departmentName("IT")
                .departmentAddress("Bangalore")
                .departmentCode("IT-06")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data Based On Department Name")
    @Disabled // will disable the particular test case
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";

        Department foundDepartment = departmentService.getDepartmentByDepartmentName(departmentName);

        assertEquals(departmentName, foundDepartment.getDepartmentName());
    }
}