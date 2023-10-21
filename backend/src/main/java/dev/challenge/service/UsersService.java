package dev.challenge.service;

import dev.challenge.mapper.SearchPageRequestMapper;
import dev.challenge.mapper.UsersMapper;
import dev.challenge.repository.UserGroupsRepository;
import dev.challenge.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UsersService {

  private final UsersMapper usersMapper;
  private final UsersRepository usersRepository;
  private final UserGroupsRepository userGroupsRepository;
  private final SearchPageRequestMapper searchPageRequestMapper;
  private final SearchPredicateResolverService predicateResolverService;

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
