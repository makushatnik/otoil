package com.otoil.ot_118_rest.controller.datasource;

import com.otoil.ot_118_rest.data.entity.datasource.Type;
import com.otoil.ot_118_rest.service.datasource.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ageev Evgeny on 02.02.2018.
 */
@RestController
@RequestMapping("/datasource/type/")
public class TypeController {

//    @Autowired
//    private TypeServiceImpl typeServiceImpl;
//
//    @GetMapping("/")
//    public Page<Type> index(int page, int size) {
//        return typeServiceImpl.findTypes(page, size);
//    }
}
