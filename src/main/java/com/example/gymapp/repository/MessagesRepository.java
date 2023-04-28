package com.example.gymapp.repository;

import com.example.gymapp.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessagesRepository extends JpaRepository<Message, Integer> {
    @Override
    <S extends Message> S save(S entity);

    @Override
    Optional<Message> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(Message entity);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends Message> entities);

    @Override
    void deleteAll();
}