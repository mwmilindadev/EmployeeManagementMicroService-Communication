package com.sprigbootacadamy.employeeservice.service;

import com.sprigbootacadamy.employeeservice.dto.ApiResponseDto;
import com.sprigbootacadamy.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long id);
}
