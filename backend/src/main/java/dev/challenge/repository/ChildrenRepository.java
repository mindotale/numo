package dev.challenge.repository;

import dev.challenge.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ChildrenRepository
    extends JpaRepository<Child, Long>, QuerydslPredicateExecutor<Child> {}
