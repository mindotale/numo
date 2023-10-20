package dev.challenge.model.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Page;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class SearchResponse<T> {

  private SearchRequest request;
  private Page<? extends T> result;
}
