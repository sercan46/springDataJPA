package com.sercanozbek.controller;

import com.sercanozbek.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeController {
    public List<EmployeeDto> findAllEmployees();
}
