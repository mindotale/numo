package dev.challenge.repository;

import dev.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UsersRepository
    extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {}
