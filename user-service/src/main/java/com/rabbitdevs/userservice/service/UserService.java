package com.rabbitdevs.userservice.service;

import com.rabbitdevs.userservice.VO.Department;
import com.rabbitdevs.userservice.VO.ResponseTemplateVO;
import com.rabbitdevs.userservice.entity.User;
import com.rabbitdevs.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside the store in UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("1 step {}", userId);
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        log.info("2 step");
        User user = userRepository.findById(userId).orElse(null);
        log.info("3 step {}", user);
        assert user != null;
        log.info("4 step");
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/v1/departments/" + user.getDepartmentId(), Department.class);
        log.info("5 step");
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;
    }
}
