package dev.challenge.mapper;

import dev.challenge.dto.UserGroupDto;
import dev.challenge.entity.UserGroup;
import dev.challenge.service.UsersService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class UserGroupsMapper {

  @Autowired protected UsersService usersService;

  public abstract UserGroupDto toDto(UserGroup userGroup);

  public abstract UserGroup toEntity(UserGroupDto userGroupDto);

  @AfterMapping
  public void setUserGroupCount(@MappingTarget UserGroupDto userGroupDto) {
    var usersCount = usersService.getUsersCountInGroup(userGroupDto.getId());
    userGroupDto.setCount(usersCount);
  }
}
