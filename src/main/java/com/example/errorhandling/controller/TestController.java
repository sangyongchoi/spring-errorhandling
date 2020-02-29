package com.example.errorhandling.controller;


import com.example.errorhandling.service.serviceMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private serviceMethod serviceMethod;

    public TestController(serviceMethod serviceMethod){
        this.serviceMethod = serviceMethod;
    }

    @GetMapping(value = "/test1")
    public String testMethod(){
        serviceMethod.testMethod1();
        return "";
    }
    @GetMapping(value = "/test2")
    public String testMethod2(){
        serviceMethod.testMethod2();
        return "";
    }
    @GetMapping(value = "/default")
    public String defaultMethod(){
        serviceMethod.defaultError();
        return "";
    }
}
