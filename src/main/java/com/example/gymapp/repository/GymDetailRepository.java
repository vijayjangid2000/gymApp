package com.example.gymapp.repository;

import com.example.gymapp.entity.GymDetail;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface GymDetailRepository extends JpaRepository<GymDetail, Integer> {
    @Override
    List<GymDetail> findAll();

    @Override
    List<GymDetail> findAll(Sort sort);

    @Override
    List<GymDetail> findAllById(Iterable<Integer> integers);

    @Override
    <S extends GymDetail> List<S> saveAll(Iterable<S> entities);

    @Override
    void flush();

    @Override
    <S extends GymDetail> S saveAndFlush(S entity);

    @Override
    <S extends GymDetail> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<GymDetail> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<GymDetail> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);

    @Override
    void deleteAllInBatch();

    @Override
    GymDetail getOne(Integer integer);

    @Override
    GymDetail getById(Integer integer);

    @Override
    GymDetail getReferenceById(Integer integer);

    @Override
    <S extends GymDetail> List<S> findAll(Example<S> example);

    @Override
    <S extends GymDetail> List<S> findAll(Example<S> example, Sort sort);

    @Override
    Page<GymDetail> findAll(Pageable pageable);

    @Override
    <S extends GymDetail> S save(S entity);

    @Override
    Optional<GymDetail> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(GymDetail entity);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends GymDetail> entities);

    @Override
    void deleteAll();

    @Override
    <S extends GymDetail> Optional<S> findOne(Example<S> example);

    @Override
    <S extends GymDetail> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends GymDetail> long count(Example<S> example);

    @Override
    <S extends GymDetail> boolean exists(Example<S> example);

    @Override
    <S extends GymDetail, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}