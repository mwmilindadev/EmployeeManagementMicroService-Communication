package com.sprigbootacadamy.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmntDto {
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
