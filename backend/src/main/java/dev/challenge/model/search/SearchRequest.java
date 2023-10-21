package dev.challenge.model.search;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SearchRequest {

  @Min(0)
  @NotNull
  private Integer page = 0;

  @Min(1)
  @Max(100)
  @NotNull
  private Integer pageSize = 10;
}
