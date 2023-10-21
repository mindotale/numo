package dev.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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

  @JsonProperty(access = Access.READ_ONLY)
  private Long count;

  @Min(0)
  private Integer minAge;

  @Min(0)
  private Integer maxAge;

  @Min(0)
  private Integer minChildCount;

  @Min(0)
  private Integer maxChildCount;

  private List<String> locations = new ArrayList<>();
  private List<String> sources = new ArrayList<>();
}
