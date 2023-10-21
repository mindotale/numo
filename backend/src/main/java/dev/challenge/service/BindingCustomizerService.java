package dev.challenge.service;

import static org.apache.commons.collections4.IterableUtils.first;

import dev.challenge.entity.QUser;
import dev.challenge.service.filter.FilterBindings;
import dev.challenge.service.filter.common.DateFilter;
import dev.challenge.service.filter.common.SizeFilter;
import dev.challenge.util.ListSize;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BindingCustomizerService {

  private final DateFilter dateFilter;
  private final SizeFilter sizeFilter;

  public FilterBindings customize() {
    var bindings = new FilterBindings();

    bindings.bind(QUser.user.location).filter((path, filter, values) -> path.in(values));
    bindings.bind(QUser.user.clientType).filter((path, filter, values) -> path.in(values));
    bindings.bind(QUser.user.activityType).filter((path, filter, values) -> path.in(values));
    bindings.bind(QUser.user.adviceFrequency).filter((path, filter, values) -> path.in(values));

    bindings
        .bind(QUser.user.lastActivityDate)
        .prefilter(
            (path, filter, values) ->
                List.of(LocalDate.now().minusDays(Long.parseLong(first(values)))))
        .filter(dateFilter::filter);

    bindings
        .bind(QUser.user.children.any().birthDate)
        .alias("children.age")
        .prefilter(
            (path, filter, values) ->
                List.of(LocalDate.now().minusYears(Long.parseLong(first(values)))))
        .filter(dateFilter::filter);

    bindings
        .bind(QUser.user.children)
        .alias("children.count")
        .prefilter((path, filter, values) -> ListSize.of(Integer.parseInt(first(values))))
        .filter(sizeFilter::filter);

    return bindings;
  }
}
