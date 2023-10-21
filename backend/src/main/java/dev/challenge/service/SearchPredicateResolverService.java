package dev.challenge.service;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import dev.challenge.entity.QUser;
import dev.challenge.entity.UserGroup;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class SearchPredicateResolverService {

  public Predicate resolve(UserGroup userGroup) {
    var predicate = new BooleanBuilder();

    if (userGroup.getMinAge() != null) {
      var date = LocalDate.now().minusDays(userGroup.getMinAge());
      predicate.and(QUser.user.birthDate.goe(date));
    }

    if (userGroup.getMaxAge() != null) {
      var date = LocalDate.now().minusDays(userGroup.getMinAge());
      predicate.and(QUser.user.birthDate.loe(date));
    }

    if (userGroup.getMaxChildCount() != null) {
      predicate.and(QUser.user.children.size().loe(userGroup.getMaxChildCount()));
    }

    if (userGroup.getMinChildCount() != null) {
      predicate.and(QUser.user.children.size().goe(userGroup.getMinChildCount()));
    }

    if (isNotEmpty(userGroup.getLocations())) {
      predicate.and(QUser.user.location.in(userGroup.getLocations()));
    }

    if (isNotEmpty(userGroup.getSources())) {
      predicate.and(QUser.user.source.in(userGroup.getSources()));
    }

    return predicate;
  }
}
