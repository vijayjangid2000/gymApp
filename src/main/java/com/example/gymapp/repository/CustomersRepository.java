package com.example.gymapp.repository;

import com.example.gymapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomersRepository extends JpaRepository<Customer, Integer> {

    @Query("select c from Customer c where upper(c.mobile_txt) like upper(?1) or upper(c.email_txt) like upper(?2)")
    Customer getCustomerByFilter(String mobile_txt, String email_txt);

    @Override
    <S extends Customer> S save(S entity);

    @Override
    Optional<Customer> findById(Integer integer);

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Customer entity);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends Customer> entities);
}