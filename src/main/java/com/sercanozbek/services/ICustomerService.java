package com.sercanozbek.services;

import com.sercanozbek.dto.CustomerDto;

public interface ICustomerService {
    public CustomerDto findCustomerById(long id);
}
