package com.rabbitdevs.cloudgateway;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
/*    private static final String USER_SERVICE = "USER-SERVICE";
    private static final String DEPARTMENT_SERVICE = "DEPARTMENT-SERVICE";*/

    @GetMapping("/userServiceFallBack")
//    @CircuitBreaker(name=USER_SERVICE, fallbackMethod = "userServiceFallBack")
    public String userServiceFallBackMethod(){
        return "User Service taking more longer. Please try again later!";
    }

    @GetMapping("/departmentFallBack")
//    @CircuitBreaker(name=DEPARTMENT_SERVICE, fallbackMethod = "departmentFallBack")
    public String departmentFallBackMethod(){
        return "Department Service taking more longer. Please try again later!";
    }
}