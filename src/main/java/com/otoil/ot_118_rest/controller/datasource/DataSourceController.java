package com.otoil.ot_118_rest.controller.datasource;

import com.otoil.ot_118_rest.data.entity.datasource.DataSource;
import com.otoil.ot_118_rest.service.datasource.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ageev Evgeny on 02.02.2018.
 */
@RestController
@RequestMapping("/datasource/")
public class DataSourceController {

//    @Autowired
//    private DataSourceService dataSourceService;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public Page<DataSource> index(int page, int size) {
//        return dataSourceService.findAll(page, size);
//    }
}
