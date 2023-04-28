package com.example.gymapp.repository;

import com.example.gymapp.entity.Payment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface PaymentsRepository extends JpaRepository<Payment, Integer> {

    @Override
    List<Payment> findAll();

    @Override
    List<Payment> findAll(Sort sort);

    @Override
    List<Payment> findAllById(Iterable<Integer> integers);

    @Override
    <S extends Payment> List<S> saveAll(Iterable<S> entities);

    @Override
    void flush();

    @Override
    <S extends Payment> S saveAndFlush(S entity);

    @Override
    <S extends Payment> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<Payment> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<Payment> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);

    @Override
    void deleteAllInBatch();

    @Override
    Payment getOne(Integer integer);

    @Override
    Payment getById(Integer integer);

    @Override
    Payment getReferenceById(Integer integer);

    @Override
    <S extends Payment> List<S> findAll(Example<S> example);

    @Override
    <S extends Payment> List<S> findAll(Example<S> example, Sort sort);

    @Override
    Page<Payment> findAll(Pageable pageable);

    @Override
    <S extends Payment> S save(S entity);

    @Override
    Optional<Payment> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Payment entity);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends Payment> entities);

    @Override
    void deleteAll();

    @Override
    <S extends Payment> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Payment> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Payment> long count(Example<S> example);

    @Override
    <S extends Payment> boolean exists(Example<S> example);

    @Override
    <S extends Payment, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}