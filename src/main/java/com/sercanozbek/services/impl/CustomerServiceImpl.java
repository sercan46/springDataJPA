package com.sercanozbek.services.impl;

import com.sercanozbek.dto.AddressDto;
import com.sercanozbek.dto.CustomerDto;
import com.sercanozbek.entities.Address;
import com.sercanozbek.entities.Customer;
import com.sercanozbek.repository.CustomerRepository;
import com.sercanozbek.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto findCustomerById(long id) {

        CustomerDto customerDto = new CustomerDto();
        AddressDto dtoAddress = new AddressDto();

        Optional<Customer> optional = customerRepository.findById(id);

        if (optional.isEmpty()) {
            return null;
        }

        Customer customer = optional.get();
        Address address = optional.get().getAddress();

        BeanUtils.copyProperties(customer, customerDto);
        BeanUtils.copyProperties(address, dtoAddress);

        customerDto.setAddress(dtoAddress);

        return customerDto;
    }
}
