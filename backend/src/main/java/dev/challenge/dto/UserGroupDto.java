package dev.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import dev.challenge.model.search.FilterParameter;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

@Data
@Accessors(chain = true)
@FieldNameConstants
public class UserGroupDto {

  @JsonProperty(access = Access.READ_ONLY)
  private Long id;

  @NotBlank private String name;

  @NotEmpty @Valid private List<FilterParameter> parameters;
}
