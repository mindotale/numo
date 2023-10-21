package dev.challenge.mapper;

import dev.challenge.dto.ChildDto;
import dev.challenge.entity.Child;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChildrenMapper {

  @Mapping(target = "parentId", source = "parent.id")
  ChildDto toDto(Child child);
}
