package com.sercanozbek.services.impl;

import com.sercanozbek.dto.AddressDto;
import com.sercanozbek.dto.CustomerDto;
import com.sercanozbek.entities.Address;
import com.sercanozbek.repository.AddressRepository;
import com.sercanozbek.services.IAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements IAddressService {
    private final AddressRepository addressRepository;

    @Override
    public AddressDto findAddressById(Long id) {
        AddressDto addressDto = new AddressDto();
        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Address address = optional.get();
        BeanUtils.copyProperties(address, addressDto);

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(address.getCustomer().getId());
        customerDto.setName(address.getCustomer().getName());


        addressDto.setCustomer(customerDto);
        return addressDto;
    }
}
