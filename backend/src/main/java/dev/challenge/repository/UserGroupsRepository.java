package dev.challenge.repository;

import dev.challenge.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserGroupsRepository
    extends JpaRepository<UserGroup, Long>, QuerydslPredicateExecutor<UserGroup> {}
