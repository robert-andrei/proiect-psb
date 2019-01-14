package com.banking.software.design.gymsubscription.service;

import com.banking.software.design.gymsubscription.model.Customer;
import com.banking.software.design.gymsubscription.model.LoginSession;
import com.banking.software.design.gymsubscription.repository.CustomerRepository;
import com.banking.software.design.gymsubscription.repository.LoginSessionRepository;
import com.banking.software.design.gymsubscription.util.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoginSessionRepository loginSessionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity signup(String username, String password, String name) {
        Optional<Customer> customerFromDb = customerRepository.findById(username);

        if (customerFromDb.isPresent()) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        Customer newCustomer = new Customer(username, new BCryptPasswordEncoder().encode(password), name);
        customerRepository.save(newCustomer);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity login(String username, String password) {
        Optional<Customer> customerFromDb = customerRepository.findById(username);

        if (!customerFromDb.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if (new BCryptPasswordEncoder().matches(password, customerFromDb.get().getPassword())) {

            String accessToken = new TokenGenerator().randomString(32);
            LoginSession newLoginSession = new LoginSession(username, new BCryptPasswordEncoder().encode(accessToken));
            loginSessionRepository.save(newLoginSession);

            return ResponseEntity.ok(accessToken);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity logout(String username, String accessToken) {
        Optional<Customer> customerFromDb = customerRepository.findById(username);
        Optional<LoginSession> loginSessionFromDb = loginSessionRepository.findById(username);

        if (!customerFromDb.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if (!loginSessionFromDb.isPresent() || !(new BCryptPasswordEncoder().matches(accessToken, loginSessionFromDb.get().getToken()))) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        loginSessionRepository.delete(loginSessionFromDb.get());
        return ResponseEntity.ok().build();
    }
}
