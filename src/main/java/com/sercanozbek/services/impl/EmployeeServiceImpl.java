package com.sercanozbek.services.impl;

import com.sercanozbek.dto.DepartmentDto;
import com.sercanozbek.dto.EmployeeDto;
import com.sercanozbek.repository.EmployeeRepository;
import com.sercanozbek.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> findAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employee -> {
                    EmployeeDto employeeDto = new EmployeeDto();
                    BeanUtils.copyProperties(employee, employeeDto);
                    employeeDto.setDepartment(new DepartmentDto(
                            employee.getDepartment().getId(),
                            employee.getDepartment().getDepartmentName()
                    ));
                    return employeeDto;
                })
                .collect(Collectors.toList());
    }
}
