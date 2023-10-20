package dev.challenge.service.filter;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import dev.challenge.enums.FilterType;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FilterPathWithBinding<P extends Path<? extends T>, T> {

  private final P path;
  private final Prefilter<P, T> prefilter;
  private final FilterBinding<P, T> binding;

  @SuppressWarnings("unchecked")
  public Predicate bind(FilterType filterType, List<?> values) {
    var prefilteredValues =
        prefilter != null
            ? prefilter.prefilter(path, filterType, (List<String>) values)
            : (List<? extends T>) values;

    if (isEmpty(prefilteredValues)) {
      return Expressions.asBoolean(true).isFalse();
    }

    return binding.bind(path, filterType, prefilteredValues);
  }
}
