package com.rabbitdevs.departmentservice.service;

import com.rabbitdevs.departmentservice.entity.Department;
import com.rabbitdevs.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department){
        log.info("Inside the store department in DepartmentService.");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long id) {
        log.info("Inside the find department by id in DepartmentService.");
        return departmentRepository.findById(id).orElse(null);
    }
}
