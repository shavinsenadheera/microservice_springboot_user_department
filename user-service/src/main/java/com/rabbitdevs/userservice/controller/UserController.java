package com.rabbitdevs.userservice.controller;

import com.rabbitdevs.userservice.VO.ResponseTemplateVO;
import com.rabbitdevs.userservice.entity.User;
import com.rabbitdevs.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User storeUser(@RequestBody User user){
        log.info("Inside the store in UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside the getUserWithDepartment in UserController");
        return userService.getUserWithDepartment(userId);
    }

    public ResponseEntity<String> userServiceFallBackMethod(Exception exception){
        log.error("Inside the fallback!");
        return new ResponseEntity<String>("Department service unavailable/unable to connect!", HttpStatus.OK);
    }
}
