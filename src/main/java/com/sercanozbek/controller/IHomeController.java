package com.sercanozbek.controller;

import com.sercanozbek.dto.HomeDto;

public interface IHomeController {
    public HomeDto findHomeById(Long id);
}
