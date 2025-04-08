package com.sercanozbek.controller;

import com.sercanozbek.dto.CustomerDto;

public interface ICustomerController {
    public CustomerDto findCustomerById(Long id);
}
