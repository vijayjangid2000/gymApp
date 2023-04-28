package com.example.gymapp.service;

import com.example.gymapp.entity.Customer;
import com.example.gymapp.repository.CustomersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {

    // this is interface so no initialize
    CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customersRepository.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customersRepository.delete(customer);
    }

    public List<Customer> getAllCustomer() {
        return customersRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customersRepository.getReferenceById(id);
    }

    public boolean registerCustomer(Customer newCustomer){

        if(checkIfCustomerExists(newCustomer)){
            // "Account with this Email or Mobile already Exists";
            return false;
        } else {
            createCustomer(newCustomer);
            // "Registration Successful";
            return true;
        }
    }

    private boolean checkIfCustomerExists(Customer customer){
        Customer oldOne = customersRepository.getCustomerByFilter(
                customer.getMobile_txt(),customer.getEmail_txt()
        );

        return oldOne != null;
    }

}
