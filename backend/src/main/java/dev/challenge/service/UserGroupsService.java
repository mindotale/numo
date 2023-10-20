package dev.challenge.service;

import dev.challenge.dto.UserGroupDto;
import dev.challenge.dto.UserGroupDto.Fields;
import dev.challenge.mapper.UserGroupsMapper;
import dev.challenge.model.search.SearchRequest;
import dev.challenge.model.search.SearchResponse;
import dev.challenge.repository.UserGroupsRepository;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserGroupsService {

  private final UserGroupsMapper userGroupsMapper;
  private final UserGroupsRepository userGroupsRepository;

  @Transactional
  public UserGroupDto createUserGroup(UserGroupDto userGroupDto) {
    return Optional.of(userGroupDto)
        .map(userGroupsMapper::toEntity)
        .map(userGroupsRepository::save)
        .map(userGroupsMapper::toDto)
        .orElseThrow();
  }

  public SearchResponse<UserGroupDto> getUserGroups(SearchRequest request) {
    var pageRequest =
        PageRequest.of(request.getPage(), request.getPageSize(), Direction.ASC, Fields.name);
    var pageResult = userGroupsRepository.findAll(pageRequest);

    var result = pageResult.stream().map(userGroupsMapper::toDto).collect(Collectors.toList());
    var page = new PageImpl<>(result, pageResult.getPageable(), pageResult.getTotalElements());
    return new SearchResponse<>(request, page);
  }
}
