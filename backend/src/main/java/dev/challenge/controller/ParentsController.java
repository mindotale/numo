package dev.challenge.controller;

import dev.challenge.dto.ChildDto;
import dev.challenge.dto.UserDto;
import dev.challenge.model.search.SearchRequest;
import dev.challenge.model.search.SearchResponse;
import dev.challenge.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@Tag(name = "parents")
@RestController
@RequiredArgsConstructor
@RequestMapping("/parents")
public class ParentsController {

  private final UsersService usersService;

  @Operation(summary = "Get parent by ID")
  @GetMapping("/{parentId}")
  public UserDto getParentById(@PathVariable Long parentId) {
    log.info("Getting parent by ID: {}", parentId);
    return usersService.getById(parentId);
  }

  @Operation(summary = "Get parents")
  @GetMapping
  public SearchResponse<UserDto> getParents(@Valid SearchRequest request) {
    log.info("Searching parents by parameters: {}", request);
    return usersService.getByRequest(request);
  }

  @Operation(summary = "Get parent children")
  @GetMapping("/{parentId}/children")
  public SearchResponse<ChildDto> getParentChildren(
      @Valid SearchRequest request, @PathVariable Long parentId) {
    log.info("Searching children for parent with ID: {}", parentId);
    return usersService.getChildren(parentId, request);
  }
}
