package com.sprigbootacadamy.employeeservice.controller;

import com.sprigbootacadamy.employeeservice.dto.ApiResponseDto;
import com.sprigbootacadamy.employeeservice.dto.EmployeeDto;
import com.sprigbootacadamy.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto>saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployee= employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto>getEmployee(@PathVariable Long id){
        ApiResponseDto employeeDto=employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
}
