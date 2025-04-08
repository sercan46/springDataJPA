package com.sercanozbek.controller.impl;

import com.sercanozbek.configuration.DataSource;
import com.sercanozbek.configuration.GlobalProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/api/property")
@RequiredArgsConstructor
public class PropertySourceController {

    private final GlobalProperties globalProperties;

    @GetMapping("/datasource")
    public DataSource getDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUrl(globalProperties.getUrl());
        dataSource.setUsername(globalProperties.getUsername());
        dataSource.setPassword(globalProperties.getPassword());
        return dataSource;
    }
}
