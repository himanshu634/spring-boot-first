package com.example.SpringBootBasics.service;

import com.example.SpringBootBasics.entity.Department;
import com.example.SpringBootBasics.exceptions.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
     Department saveDepartment(Department department);

     List<Department> fetchDepartments();

     Department getDepartment(Long id) throws DepartmentNotFoundException;

     void deleteDepartment(Long id);

     Department updateDepartment(Long departmentId, Department department);

     Department getDepartmentByDepartmentName(String departmentName);
}
