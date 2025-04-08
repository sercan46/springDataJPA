package com.sercanozbek.controller;

import com.sercanozbek.dto.AddressDto;

public interface IAddressController {
    public AddressDto findAddressById(Long id);
}
