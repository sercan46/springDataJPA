package com.sercanozbek.controller.impl;

import com.sercanozbek.controller.IEmployeeController;
import com.sercanozbek.dto.EmployeeDto;
import com.sercanozbek.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
@RequiredArgsConstructor
public class EmployeeControllerImpl implements IEmployeeController {

    private final IEmployeeService employeeService;

    @GetMapping(path = "/list")
    @Override
    public List<EmployeeDto> findAllEmployees() {
        return employeeService.findAllEmployees();
    }
}
