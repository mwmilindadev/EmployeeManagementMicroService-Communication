package com.sprigbootacadamy.departmentservice.controller;

import com.sprigbootacadamy.departmentservice.dto.DepartmntDto;
import com.sprigbootacadamy.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<DepartmntDto>saveDepartmet(@RequestBody DepartmntDto departmntDto){
    DepartmntDto savedDeparment=departmentService.saveDepartment(departmntDto);
    return new ResponseEntity<>(savedDeparment, HttpStatus.CREATED);
    }

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmntDto>getDepartment(@PathVariable(value = "department-code") String departmentCode ){
        DepartmntDto departmntDto=departmentService.getDepartmentbyCode(departmentCode);
        return  new ResponseEntity<>(departmntDto,HttpStatus.OK);

    }
}
