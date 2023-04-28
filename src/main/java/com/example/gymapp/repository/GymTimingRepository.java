package com.example.gymapp.repository;

import com.example.gymapp.entity.GymTiming;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface GymTimingRepository extends JpaRepository<GymTiming, Integer> {

    @Override
    List<GymTiming> findAll();

    @Override
    List<GymTiming> findAll(Sort sort);

    @Override
    List<GymTiming> findAllById(Iterable<Integer> integers);

    @Override
    <S extends GymTiming> List<S> saveAll(Iterable<S> entities);

    @Override
    void flush();

    @Override
    <S extends GymTiming> S saveAndFlush(S entity);

    @Override
    <S extends GymTiming> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<GymTiming> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<GymTiming> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Integer> integers);

    @Override
    void deleteAllInBatch();

    @Override
    GymTiming getOne(Integer integer);

    @Override
    GymTiming getById(Integer integer);

    @Override
    GymTiming getReferenceById(Integer integer);

    @Override
    <S extends GymTiming> List<S> findAll(Example<S> example);

    @Override
    <S extends GymTiming> List<S> findAll(Example<S> example, Sort sort);

    @Override
    Page<GymTiming> findAll(Pageable pageable);

    @Override
    <S extends GymTiming> S save(S entity);

    @Override
    Optional<GymTiming> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(GymTiming entity);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends GymTiming> entities);

    @Override
    void deleteAll();

    @Override
    <S extends GymTiming> Optional<S> findOne(Example<S> example);

    @Override
    <S extends GymTiming> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends GymTiming> long count(Example<S> example);

    @Override
    <S extends GymTiming> boolean exists(Example<S> example);

    @Override
    <S extends GymTiming, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}