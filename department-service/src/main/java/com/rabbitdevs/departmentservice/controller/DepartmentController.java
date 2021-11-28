package com.rabbitdevs.departmentservice.controller;

import com.rabbitdevs.departmentservice.entity.Department;
import com.rabbitdevs.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department storeDepartment(@RequestBody Department department){
        log.info("Inside the store department in DepartmentController.");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Long id){
        log.info("Inside the get by id department in DepartmentController.");
        return departmentService.findDepartmentById(id);
    }
}
