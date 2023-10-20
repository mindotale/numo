package dev.challenge.mapper;

import dev.challenge.dto.UserGroupDto;
import dev.challenge.entity.UserGroup;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserGroupsMapper {

  UserGroupDto toDto(UserGroup userGroup);

  UserGroup toEntity(UserGroupDto userGroupDto);
}
