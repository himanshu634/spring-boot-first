package com.example.SpringBootBasics.controller;

import com.example.SpringBootBasics.entity.Department;
import com.example.SpringBootBasics.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.xpath.XPath;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save_department")
    public Department saveDepartment(@RequestBody Department department){
            return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments(){
        return departmentService.fetchDepartments();
    }

    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable("id") Long id){
        return departmentService.getDepartment(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return "Department " + departmentId + " deleted successfully.";
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByDepartmentName(departmentName);
    }

}
