package com.sercanozbek.services;

import com.sercanozbek.dto.AddressDto;

public interface IAddressService {
    public AddressDto findAddressById(Long id);
}