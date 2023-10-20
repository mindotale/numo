package dev.challenge.service.filter.common;

import static java.lang.String.format;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.ListPath;
import dev.challenge.enums.FilterType;
import java.util.List;
import org.springframework.data.querydsl.QuerydslUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class SizeFilter {

  public <T> BooleanExpression filter(
      ListPath<T, ? extends EntityPath<T>> path,
      FilterType filterType,
      List<? extends List<T>> values) {
    switch (filterType) {
      case EQUALS:
        return path.size().eq(values.size());
      case GREATER_THAN:
        return path.size().gt(values.size());
      case LESS_THAN:
        return path.size().lt(values.size());
      case GREATER_THAN_OR_EQUAL_TO:
        return path.size().goe(values.size());
      case LESS_THAN_OR_EQUAL_TO:
        return path.size().loe(values.size());
      default:
        throw new ResponseStatusException(
            HttpStatus.BAD_REQUEST,
            format(
                "Filter type '%s' cannot be applied to field '%s'",
                filterType, QuerydslUtils.toDotPath((Path<?>) path)));
    }
  }
}
