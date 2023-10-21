package dev.challenge.service;

import dev.challenge.dto.ChildDto;
import dev.challenge.dto.UserDto;
import dev.challenge.dto.UserGroupDto.Fields;
import dev.challenge.entity.QChild;
import dev.challenge.mapper.ChildrenMapper;
import dev.challenge.mapper.SearchPageRequestMapper;
import dev.challenge.mapper.UsersMapper;
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
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UsersService {

  private final UsersMapper usersMapper;
  private final ChildrenMapper childrenMapper;
  private final UsersRepository usersRepository;
  private final ChildrenRepository childrenRepository;
  private final UserGroupsRepository userGroupsRepository;
  private final SearchPageRequestMapper searchPageRequestMapper;
  private final SearchPredicateResolverService predicateResolverService;

  public UserDto getById(Long id) {
    return usersRepository
        .findById(id)
        .map(usersMapper::toDto)
        .orElseThrow(
            () ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("User with ID %s not found", id)));
  }

  public SearchResponse<UserDto> getByRequest(SearchRequest request) {
    var pageRequest =
        PageRequest.of(request.getPage(), request.getPageSize(), Direction.ASC, Fields.name);
    var pageResult = usersRepository.findAll(pageRequest);

    var result = pageResult.stream().map(usersMapper::toDto).collect(Collectors.toList());
    var page = new PageImpl<>(result, pageResult.getPageable(), pageResult.getTotalElements());
    return new SearchResponse<>(request, page);
  }

  public SearchResponse<ChildDto> getChildren(Long parentId, SearchRequest request) {
    usersRepository
        .findById(parentId)
        .orElseThrow(
            () ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("User with ID %s not found", parentId)));

    var pageRequest =
        PageRequest.of(request.getPage(), request.getPageSize(), Direction.ASC, Fields.name);
    var pageResult = childrenRepository.findAll(QChild.child.parent.id.eq(parentId), pageRequest);

    var result = pageResult.stream().map(childrenMapper::toDto).collect(Collectors.toList());
    var page = new PageImpl<>(result, pageResult.getPageable(), pageResult.getTotalElements());
    return new SearchResponse<>(request, page);
  }

  public Long getUsersCountInGroup(Long userGroupId) {
    var userGroup =
        userGroupsRepository
            .findById(userGroupId)
            .orElseThrow(
                () ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("User Group with %s not found", userGroupId)));

    var predicate = predicateResolverService.resolve(userGroup);
    return usersRepository.count(predicate);
  }

  //  public SearchResponse<UserDto> getUsersBySearchFilter(SearchRequest request) {
  //    var pageRequest = searchPageRequestMapper.toPageRequest(request);
  //    var predicate = predicateResolverService.resolve(request.getFilter());
  //
  //    var pageResult = usersRepository.findAll(predicate, pageRequest);
  //
  //    var result = pageResult.stream().map(usersMapper::toDto).collect(Collectors.toList());
  //    var page = new PageImpl<>(result, pageResult.getPageable(), pageResult.getTotalElements());
  //    return new SearchResponse<>(request, page);
  //  }
}
