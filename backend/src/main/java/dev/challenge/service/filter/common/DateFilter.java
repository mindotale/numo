package dev.challenge.service.filter.common;

import static java.lang.String.format;
import static org.apache.commons.collections4.IterableUtils.first;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DatePath;
import dev.challenge.enums.FilterType;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.querydsl.QuerydslUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class DateFilter {

  public BooleanExpression filter(
      DatePath<LocalDate> path, FilterType filterType, List<? extends LocalDate> values) {
    switch (filterType) {
      case GREATER_THAN:
        return path.lt(first(values));
      case LESS_THAN:
        return path.gt(first(values));
      case GREATER_THAN_OR_EQUAL_TO:
        return path.loe(first(values));
      case LESS_THAN_OR_EQUAL_TO:
        return path.goe(first(values));
      default:
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            format(
                "Filter type '%s' cannot be applied to field '%s'",
                filterType, QuerydslUtils.toDotPath((Path<?>) path)));
    }
  }
}
