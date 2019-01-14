package com.banking.software.design.gymsubscription.controller;

import com.banking.software.design.gymsubscription.service.CustomerService;
import com.banking.software.design.gymsubscription.util.MappingPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(MappingPaths.CUSTOMER_PATH)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = MappingPaths.CUSTOMER_SIGNUP, method = RequestMethod.POST)
    public ResponseEntity<?> signup(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password,
            @RequestParam(name = "name") String name) {
        return customerService.signup(username, password, name);
    }

    @RequestMapping(value = MappingPaths.CUSTOMER_LOGIN)
    public ResponseEntity<?> login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        return customerService.login(username, password);
    }

    @RequestMapping(value = MappingPaths.CUSTOMER_LOGOUT)
    public ResponseEntity<?> logout(@RequestParam(name = "username") String username, @RequestParam(name = "accessToken") String accessToken) {
        return customerService.logout(username, accessToken);
    }
}