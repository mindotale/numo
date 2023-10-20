package dev.challenge.service.filter;

import static java.lang.String.format;
import static org.springframework.data.querydsl.QuerydslUtils.toDotPath;

import com.querydsl.core.types.Path;
import dev.challenge.entity.QUser;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.mapping.PropertyPath;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

public class FilterBindings {

  private final Map<String, String> pathAliases = new HashMap<>();
  private final Map<String, FilterPathWithBinding<? extends Path<?>, ?>> pathBindings =
      new LinkedHashMap<>();

  @SafeVarargs
  public final <P extends Path<T>, T> FilterPathBinder<P, T> bind(P... paths) {
    Assert.notEmpty(paths, "At least one path has to be provided");
    return new FilterPathBinder<>(this, Arrays.asList(paths));
  }

  protected <P extends Path<? extends T>, T> void registerBinding(
      P path, @Nullable Prefilter<P, T> prefilter, FilterBinding<P, T> binding) {
    pathBindings.put(toDotPath(path), new FilterPathWithBinding<>(path, prefilter, binding));
  }

  protected void registerAlias(String alias, Path<?> path) {
    var aliasedPath = pathAliases.get(alias);
    Assert.isNull(
        aliasedPath, format("Alias '%s' is already used for property '%s'", alias, aliasedPath));
    pathAliases.put(alias, toDotPath(path));
  }

  public Optional<? extends FilterPathWithBinding<? extends Path<?>, ?>> getBindingForProperty(
      String property) {
    var aliasBinding = Optional.of(property).map(pathAliases::get).map(pathBindings::get);
    if (aliasBinding.isPresent()) {
      return aliasBinding;
    }

    var path = PropertyPath.from(property, QUser.user.getType()).toDotPath();
    return Optional.of(path).map(pathBindings::get);
  }
}
