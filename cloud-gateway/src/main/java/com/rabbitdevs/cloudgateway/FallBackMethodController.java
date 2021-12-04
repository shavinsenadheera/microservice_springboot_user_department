package com.rabbitdevs.cloudgateway;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackMethodController {
/*
    private static final String USER_SERVICE = "USER-SERVICE";
    private static final String DEPARTMENT_SERVICE = "DEPARTMENT-SERVICE";
*/

    @RequestMapping("/userServiceFallBack")
//  @CircuitBreaker(name=USER_SERVICE, fallbackMethod = "userServiceFallBack")
    public Mono<String> userServiceFallBackMethod(){
        return Mono.just("User Service taking more longer. Please try again later!");
    }

    @RequestMapping("/departmentFallBack")
//  @CircuitBreaker(name=DEPARTMENT_SERVICE, fallbackMethod = "departmentFallBack")
    public Mono<String> departmentFallBackMethod(){
        return Mono.just("Department Service taking more longer. Please try again later!");
    }
}