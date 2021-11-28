package com.rabbitdevs.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "User Service taking more longer. Please try again later!";
    }

    @GetMapping("departmentFallBack")
    public String departmentFallBackMethod(){
        return "Department Service taking more longer. Please try again later!";
    }

}
