package dev.challenge.service;

import static org.apache.commons.collections4.ListUtils.emptyIfNull;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import dev.challenge.model.search.FilterParameter;
import dev.challenge.service.filter.FilterPathWithBinding;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RequiredArgsConstructor
public class SearchPredicateResolverService {

  private final TypeConverterService typeConverterService;
  private final BindingCustomizerService bindingCustomizerService;

  public Predicate resolve(List<FilterParameter> filters) {
    var predicate = new BooleanBuilder();
    var bindings = bindingCustomizerService.customize();

    emptyIfNull(filters)
        .forEach(
            filter -> {
              var binding =
                  bindings
                      .getBindingForProperty(filter.getProperty())
                      .orElseThrow(
                          () ->
                              new ResponseStatusException(
                                  HttpStatus.BAD_REQUEST,
                                  "Filtering not allowed by property: " + filter.getProperty()));

              predicate.and(invokeBinding(binding, filter));
            });

    return Optional.of(predicate).map(BooleanBuilder::getValue).orElseGet(BooleanBuilder::new);
  }

  protected Predicate invokeBinding(
      FilterPathWithBinding<? extends Path<?>, ?> binding, FilterParameter filter) {
    var rawValues = emptyIfNull(filter.getValues());
    var values =
        isEmpty(binding.getPrefilter())
            ? typeConverterService.convert(rawValues, binding.getPath())
            : rawValues;

    return binding.bind(filter.getType(), values);
  }
}
