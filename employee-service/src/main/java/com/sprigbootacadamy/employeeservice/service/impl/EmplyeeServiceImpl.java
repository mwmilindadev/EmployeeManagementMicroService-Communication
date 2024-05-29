package com.sprigbootacadamy.employeeservice.service.impl;

import com.sprigbootacadamy.employeeservice.dto.ApiResponseDto;
import com.sprigbootacadamy.employeeservice.dto.DepartmentDto;
import com.sprigbootacadamy.employeeservice.dto.EmployeeDto;
import com.sprigbootacadamy.employeeservice.entity.Employee;
import com.sprigbootacadamy.employeeservice.repository.EmplyeeRepository;
import com.sprigbootacadamy.employeeservice.service.APIClient;
import com.sprigbootacadamy.employeeservice.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.Optional;

@Service

public class EmplyeeServiceImpl implements EmployeeService {
    @Autowired
    private EmplyeeRepository emplyeeRepository;
    //@Autowired
    //private RestTemplate restTemplate;
    //@Autowired
    //private WebClient webClient;
   @Autowired
   private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        Employee savedEmployee=emplyeeRepository.save(employee);

        EmployeeDto saveEmployeeDto= new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );
        return saveEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long id) {
        Optional<Employee> employee = Optional.of(emplyeeRepository.findById(id).get());
  // Communication with RestTemplate
//      ResponseEntity<DepartmentDto> departmentDtoResponse =
//                      restTemplate.getForEntity("http://localhost:8080/api/department/"+employee.get()
//                      .getDepartmentCode(), DepartmentDto.class);
//
//      DepartmentDto departmentDto=departmentDtoResponse.getBody();
//Communication with web client
//        DepartmentDto departmentDto=webClient.get().uri("http://localhost:8080/api/department/"+employee.get().getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
        //Communication with FeignClient
        DepartmentDto departmentDto=apiClient.getDepartment(employee.get().getDepartmentCode());

        EmployeeDto employeeDto= new EmployeeDto(
                employee.get().getId(),
                employee.get().getFirstName(),
                employee.get().getLastName(),
                employee.get().getEmail(),
                employee.get().getDepartmentCode()

        );

        ApiResponseDto apiResponseDto =new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
