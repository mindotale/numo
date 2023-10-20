package dev.challenge.service;

import dev.challenge.dto.UserDto;
import dev.challenge.mapper.SearchPageRequestMapper;
import dev.challenge.mapper.UsersMapper;
import dev.challenge.model.search.SearchRequest;
import dev.challenge.model.search.SearchResponse;
import dev.challenge.repository.UsersRepository;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

  private final UsersMapper usersMapper;
  private final UsersRepository usersRepository;
  private final SearchPageRequestMapper searchPageRequestMapper;
  private final SearchPredicateResolverService predicateResolverService;

  public SearchResponse<UserDto> getUsersBySearchFilter(SearchRequest request) {
    var pageRequest = searchPageRequestMapper.toPageRequest(request);
    var predicate = predicateResolverService.resolve(request.getFilter());

    var pageResult = usersRepository.findAll(predicate, pageRequest);

    var result = pageResult.stream().map(usersMapper::toDto).collect(Collectors.toList());
    var page = new PageImpl<>(result, pageResult.getPageable(), pageResult.getTotalElements());
    return new SearchResponse<>(request, page);
  }
}
