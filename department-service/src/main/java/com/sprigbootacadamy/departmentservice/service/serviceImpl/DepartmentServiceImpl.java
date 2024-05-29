package com.sprigbootacadamy.departmentservice.service.serviceImpl;

import com.sprigbootacadamy.departmentservice.dto.DepartmntDto;
import com.sprigbootacadamy.departmentservice.entity.Department;
import com.sprigbootacadamy.departmentservice.repository.DepartmentRepository;
import com.sprigbootacadamy.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmntDto saveDepartment(DepartmntDto departmntDto) {
        Department department = new Department(
                departmntDto.getId(),
                departmntDto.getDepartmentName(),
                departmntDto.getDepartmentDescription(),
                departmntDto.getDepartmentCode()
        );
        Department saveDepartment=departmentRepository.save(department);
        DepartmntDto departmntDto1= new DepartmntDto(
                saveDepartment.getId(),
                saveDepartment.getDepartmentName(),
                saveDepartment.getDepartmentDescription(),
                saveDepartment.getDepartmentCode()
        );

        return departmntDto1;
    }

    @Override
    public DepartmntDto getDepartmentbyCode(String code) {
        Department department=departmentRepository.findByDepartmentCode(code);
        DepartmntDto departmntDto= new DepartmntDto(department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode());
        return departmntDto;
    }
}
