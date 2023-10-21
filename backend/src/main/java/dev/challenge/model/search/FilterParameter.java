package dev.challenge.model.search;

import dev.challenge.enums.FilterType;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FilterParameter {

  @NotEmpty private String name;
  @NotNull private FilterType operator;
  @NotEmpty private List<String> values;
}
