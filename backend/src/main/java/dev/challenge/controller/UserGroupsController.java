package dev.challenge.controller;

import dev.challenge.dto.UserGroupDto;
import dev.challenge.model.search.SearchRequest;
import dev.challenge.model.search.SearchResponse;
import dev.challenge.service.UserGroupsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@Tag(name = "groups")
@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class UserGroupsController {

  private final UserGroupsService userGroupsService;

  @Operation(summary = "Create new user group")
  @PostMapping
  public UserGroupDto createUserGroup(
      @Parameter(description = "User group parameters", required = true) @Valid @RequestBody
          UserGroupDto userGroup) {
    log.info("Creating new user group with parameters: {}", userGroup);
    return userGroupsService.createUserGroup(userGroup);
  }

  @Operation(summary = "Get user group by ID")
  @GetMapping("/{groupId}")
  public UserGroupDto getUserGroupById(@PathVariable Long groupId) {
    log.info("Getting user group by ID: {}", groupId);
    return userGroupsService.getUserGroupById(groupId);
  }

  @Operation(summary = "Update user group")
  @PutMapping("/{groupId}")
  public UserGroupDto updateUserGroup(
      @Parameter(description = "User group parameters", required = true) @Valid @RequestBody
          UserGroupDto userGroup,
      @PathVariable Long groupId) {
    log.info("Creating new user group with parameters: {}", userGroup);
    return userGroupsService.updateUserGroup(groupId, userGroup);
  }

  @Operation(summary = "Get user groups")
  @GetMapping
  public SearchResponse<UserGroupDto> getUserGroups(@Valid SearchRequest request) {
    log.info("Searching user groups by parameters: {}", request);
    return userGroupsService.getUserGroups(request);
  }

  @Operation(summary = "Delete user group")
  @DeleteMapping("/{groupId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteUserGroup(@PathVariable Long groupId) {
    log.info("Deleting user group with ID: {}", groupId);
    userGroupsService.deleteUserGroup(groupId);
  }

  //  @Operation(summary = "Get all user groups")
  //  @GetMapping("/{groupId}/users")
  //  public SearchResponse<UserGroupDto> getUserGroups(
  //      @PathVariable String groupId) {
  //    log.info("Getting users in group ID: {}", groupId);
  //    return userGroupsService.getUserGroups(request);
  //  }
}
