package com.sercanozbek.controller.impl;

import com.sercanozbek.controller.ICustomerController;
import com.sercanozbek.dto.CustomerDto;
import com.sercanozbek.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/customer")
@RequiredArgsConstructor
public class CustomerControllerImpl implements ICustomerController {

    private final ICustomerService customerService;

    @GetMapping(path = "/list/{id}")
    @Override
    public CustomerDto findCustomerById(@PathVariable(name = "id") Long id) {
        return customerService.findCustomerById(id);
    }
}
