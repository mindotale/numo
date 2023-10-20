package dev.challenge.service.filter;

import static org.apache.commons.collections4.IterableUtils.first;

import com.querydsl.core.types.Path;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;

@RequiredArgsConstructor
public class FilterPathBinder<P extends Path<? extends T>, T> {

  private final FilterBindings bindings;
  private final List<P> paths;

  private Prefilter<P, T> prefilter;

  public FilterBindings filter(FilterBinding<P, T> binding) {
    paths.forEach(path -> bindings.registerBinding(path, prefilter, binding));
    return bindings;
  }

  public FilterPathBinder<P, T> alias(String alias) {
    Assert.isTrue(paths.size() == 1, "Alias can be used only for single property binding");
    bindings.registerAlias(alias, first(paths));
    return this;
  }

  public FilterPathBinder<P, T> prefilter(Prefilter<P, T> prefilter) {
    this.prefilter = prefilter;
    return this;
  }
}
