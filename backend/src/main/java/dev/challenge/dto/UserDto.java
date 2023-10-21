package dev.challenge.dto;

import java.time.LocalDate;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto {

  private Long id;
  private String name;
  private String phone;
  private String location;
  private String source;
  private Integer age;
  private LocalDate birthDate;
}
