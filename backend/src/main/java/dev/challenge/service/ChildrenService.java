package dev.challenge.service;

import dev.challenge.dto.ChildDto;
import dev.challenge.dto.UserGroupDto.Fields;
import dev.challenge.mapper.ChildrenMapper;
import dev.challenge.model.search.SearchRequest;
import dev.challenge.model.search.SearchResponse;
import dev.challenge.repository.ChildrenRepository;
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
public class ChildrenService {

  private final ChildrenMapper childrenMapper;
  private final ChildrenRepository childrenRepository;

  public ChildDto getChildById(Long childId) {
    return childrenRepository
        .findById(childId)
        .map(childrenMapper::toDto)
        .orElseThrow(
            () ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Child with ID %s not found", childId)));
  }

  public SearchResponse<ChildDto> getChildren(SearchRequest request) {
    var pageRequest =
        PageRequest.of(request.getPage(), request.getPageSize(), Direction.ASC, Fields.name);
    var pageResult = childrenRepository.findAll(pageRequest);

    var result = pageResult.stream().map(childrenMapper::toDto).collect(Collectors.toList());
    var page = new PageImpl<>(result, pageResult.getPageable(), pageResult.getTotalElements());
    return new SearchResponse<>(request, page);
  }
}
