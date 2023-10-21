package dev.challenge.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dev.challenge.dto.ChildDto;
import dev.challenge.dto.UserGroupDto;
import dev.challenge.dto.UserGroupDto.Fields;
import dev.challenge.entity.QChild;
import dev.challenge.entity.QUser;
import dev.challenge.mapper.ChildrenMapper;
import dev.challenge.mapper.UserGroupsMapper;
import dev.challenge.model.search.SearchRequest;
import dev.challenge.model.search.SearchResponse;
import dev.challenge.repository.ChildrenRepository;
import dev.challenge.repository.UserGroupsRepository;
import dev.challenge.repository.UsersRepository;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserGroupsService {

  private final JPAQueryFactory jpaQueryFactory;
  private final UsersRepository usersRepository;
  private final ChildrenMapper childrenMapper;
  private final UserGroupsMapper userGroupsMapper;
  private final ChildrenRepository childrenRepository;
  private final UserGroupsRepository userGroupsRepository;
  private final SearchPredicateResolverService predicateResolverService;

  @Transactional
  public UserGroupDto createUserGroup(UserGroupDto userGroupDto) {
    var userGroup = userGroupsMapper.toEntity(userGroupDto);
    var storedUserGroup = userGroupsRepository.save(userGroup);
    return userGroupsMapper.toDto(storedUserGroup);
  }

  @Transactional
  public UserGroupDto updateUserGroup(Long id, UserGroupDto userGroupDto) {
    var existingUserGroup =
        userGroupsRepository
            .findById(id)
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND, String.format("User Group with %s not found", id)));
    var userGroup = userGroupsMapper.toEntity(userGroupDto);
    userGroup.setId(existingUserGroup.getId());

    var storedUserGroup = userGroupsRepository.save(userGroup);
    return userGroupsMapper.toDto(storedUserGroup);
  }

  public UserGroupDto getUserGroupById(Long id) {
    return userGroupsRepository
        .findById(id)
        .map(userGroupsMapper::toDto)
        .orElseThrow(
            () ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("User Group with %s not found", id)));
  }

  public SearchResponse<UserGroupDto> getUserGroups(SearchRequest request) {
    var pageRequest =
        PageRequest.of(request.getPage(), request.getPageSize(), Direction.ASC, Fields.name);
    var pageResult = userGroupsRepository.findAll(pageRequest);

    var result = pageResult.stream().map(userGroupsMapper::toDto).collect(Collectors.toList());
    var page = new PageImpl<>(result, pageResult.getPageable(), pageResult.getTotalElements());
    return new SearchResponse<>(request, page);
  }

  public SearchResponse<ChildDto> getGroupChildren(Long groupId, SearchRequest request) {
    var userGroup =
        userGroupsRepository
            .findById(groupId)
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("User Group with %s not found", groupId)));
    var predicate = predicateResolverService.resolve(userGroup);
    var userIds =
        jpaQueryFactory.select(QUser.user.id).from(QUser.user).where(predicate).fetchAll();

    var pageRequest =
        PageRequest.of(request.getPage(), request.getPageSize(), Direction.ASC, Fields.name);
    var pageResult = childrenRepository.findAll(QChild.child.parent.id.in(userIds), pageRequest);

    var result = pageResult.stream().map(childrenMapper::toDto).collect(Collectors.toList());
    var page = new PageImpl<>(result, pageResult.getPageable(), pageResult.getTotalElements());
    return new SearchResponse<>(request, page);
  }

  public void deleteUserGroup(Long groupId) {
    userGroupsRepository
        .findById(groupId)
        .ifPresentOrElse(
            userGroupsRepository::delete,
            () -> {
              throw new ResponseStatusException(
                  HttpStatus.NOT_FOUND, String.format("User Group with %s not found", groupId));
            });
  }
}
