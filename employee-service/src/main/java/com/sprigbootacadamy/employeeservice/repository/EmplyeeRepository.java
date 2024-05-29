package com.sprigbootacadamy.employeeservice.repository;

import com.sprigbootacadamy.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmplyeeRepository extends JpaRepository<Employee,Long> {
}
