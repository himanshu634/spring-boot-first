package com.example.SpringBootBasics.controller;

import com.example.SpringBootBasics.entity.Department;
import com.example.SpringBootBasics.exceptions.DepartmentNotFoundException;
import com.example.SpringBootBasics.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/save_department")
    public Department saveDepartment(@Valid @RequestBody Department department){
        System.out.println(department);
            LOGGER.info("Inside save department in logger.");
            return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
        LOGGER.info("Inside fetch department in logger.");
        return departmentService.fetchDepartments();
    }

    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        LOGGER.info("Inside get department with id in logger.");
        return departmentService.getDepartment(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId) {
        LOGGER.info("Inside delete department in logger.");
        departmentService.deleteDepartment(departmentId);
        return "Department " + departmentId + " deleted successfully.";
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        LOGGER.info("Inside update department in logger.");
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside get department by name in logger.");
        return departmentService.getDepartmentByDepartmentName(departmentName);
    }

}
