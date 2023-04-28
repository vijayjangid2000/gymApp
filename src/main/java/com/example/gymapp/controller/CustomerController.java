package com.example.gymapp.controller;

import com.example.gymapp.entity.Customer;
import com.example.gymapp.service.CustomersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomersService customersService;

    public CustomerController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<String> getCustomers(){
        List<Customer> list = customersService.getAllCustomer();
        return new ResponseEntity<>( list.toString(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addCustomer2")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){

        Customer newCustomer =customersService.createCustomer(customer);

        return new ResponseEntity<>( newCustomer.toString(),
                HttpStatus.ACCEPTED);
    }

}
