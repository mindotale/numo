package dev.challenge.mapper;

import dev.challenge.dto.UserDto;
import dev.challenge.entity.User;
import java.time.LocalDate;
import java.time.Period;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsersMapper {

  UserDto toDto(User user);

  @AfterMapping
  default void setAge(@MappingTarget UserDto userDto) {
    userDto.setAge(Period.between(userDto.getBirthDate(), LocalDate.now()).getYears());
  }
}
