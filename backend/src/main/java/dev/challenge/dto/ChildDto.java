package dev.challenge.dto;

import java.time.LocalDate;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ChildDto {

  private Long id;
  private Long parentId;
  private String name;
  private LocalDate birthDate;
}
