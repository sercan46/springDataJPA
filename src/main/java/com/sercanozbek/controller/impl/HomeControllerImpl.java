package com.sercanozbek.controller.impl;

import com.sercanozbek.controller.IHomeController;
import com.sercanozbek.dto.HomeDto;
import com.sercanozbek.services.IHomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/home")
@RequiredArgsConstructor
public class HomeControllerImpl implements IHomeController {

    private final IHomeService homeService;

    @GetMapping(path = "/{id}")
    @Override
    public HomeDto findHomeById(@PathVariable(name = "id") Long id) {
        return homeService.findByHomeId(id);
    }
}
