package com.example.SpringBootBasics.service;

import com.example.SpringBootBasics.entity.Department;
import com.example.SpringBootBasics.exceptions.DepartmentNotFoundException;
import com.example.SpringBootBasics.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long id) throws DepartmentNotFoundException{
        Optional<Department> departmentOptional = departmentRepository.findById(id);

        if(!departmentOptional.isPresent()){
            throw new DepartmentNotFoundException("Department Not Found");
        }

        return departmentOptional.get();
    }

    @Override
    public void deleteDepartment(Long departmentId) throws DepartmentNotFoundException{
        try {
            departmentRepository.deleteById(departmentId);
        }catch(Exception exception){
            throw new DepartmentNotFoundException("Please enter valid department Id");
        }
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department){
        Department depDB = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department getDepartmentByDepartmentName(String departmentName){
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
