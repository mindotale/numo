package dev.challenge.service.filter;

import com.querydsl.core.types.Path;
import dev.challenge.enums.FilterType;
import java.util.List;

public interface Prefilter<P extends Path<? extends T>, T> {

  List<T> prefilter(P path, FilterType filterType, List<String> values);
}
