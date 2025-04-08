package com.sercanozbek.controller.impl;

import com.sercanozbek.controller.IAddressController;
import com.sercanozbek.dto.AddressDto;
import com.sercanozbek.services.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/address")
@RequiredArgsConstructor
public class AddressControllerImpl implements IAddressController {

    private final IAddressService addressService;

    @GetMapping(path = "/list/{id}")
    @Override
    public AddressDto findAddressById(@PathVariable(name = "id") Long id) {
        return addressService.findAddressById(id);
    }
}
