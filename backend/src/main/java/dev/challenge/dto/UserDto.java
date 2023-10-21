package dev.challenge.dto;

import dev.challenge.enums.ActivityType;
import dev.challenge.enums.AdviceFrequency;
import dev.challenge.enums.ClientType;
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
  private Integer age;
  private LocalDate birthDate;
  private ClientType clientType;
  private ActivityType activityType;
  private AdviceFrequency adviceFrequency;
}
