package dev.challenge.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@Tag(name = "users")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

  private final UsersService usersService;

  @Operation(summary = "Get users pageable")
  @PostMapping("/search")
  public SearchResponse<UserDto> getUserGroups(@Valid @RequestBody SearchRequest request) {
    log.info("Getting users by filter parameters: {}", request);
    return usersService.getUsersBySearchFilter(request);
  }
}
