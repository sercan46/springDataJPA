package com.sercanozbek.services;

import com.sercanozbek.dto.HomeDto;

public interface IHomeService {
    public HomeDto findByHomeId(Long id);
}
