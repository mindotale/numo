package dev.challenge.service.filter;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import dev.challenge.enums.FilterType;
import java.util.List;

@FunctionalInterface
public interface FilterBinding<P extends Path<? extends T>, T> {

  Predicate bind(P path, FilterType filterType, List<? extends T> values);
}
