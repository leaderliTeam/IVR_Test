package com.pccc.sip.ivrtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2022-03-31 17:21
 */
@RestController
public class HelloController {

    @GetMapping("sayHello")
    public String  sayHello(){
        return "sayHello";
    }
}
