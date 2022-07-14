package com.example.SpringBootBasics.service;

import com.example.SpringBootBasics.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
     Department saveDepartment(Department department);

     List<Department> fetchDepartments();

     Department getDepartment(Long id);

     void deleteDepartment(Long id);

     Department updateDepartment(Long departmentId, Department department);

     Department getDepartmentByDepartmentName(String departmentName);
}
