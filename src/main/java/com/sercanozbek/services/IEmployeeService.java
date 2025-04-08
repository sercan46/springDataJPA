package com.sercanozbek.services;

import com.sercanozbek.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeService {
    public List<EmployeeDto> findAllEmployees();
}
