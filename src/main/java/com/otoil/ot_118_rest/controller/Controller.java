package com.otoil.ot_118_rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ageev Evgeny on 02.02.2018.
 */
@RestController
@RequestMapping("/")
public class Controller {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
