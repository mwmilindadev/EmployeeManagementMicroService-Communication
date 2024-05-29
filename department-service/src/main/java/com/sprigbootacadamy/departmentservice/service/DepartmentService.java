package com.sprigbootacadamy.departmentservice.service;

import com.sprigbootacadamy.departmentservice.dto.DepartmntDto;

public interface DepartmentService {
    DepartmntDto saveDepartment(DepartmntDto departmntDto);


    DepartmntDto getDepartmentbyCode(String code);
}
