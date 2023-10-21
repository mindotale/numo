package dev.challenge.controller;

import dev.challenge.dto.ChildDto;
import dev.challenge.model.search.SearchRequest;
import dev.challenge.model.search.SearchResponse;
import dev.challenge.service.ChildrenService;
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
@Tag(name = "children")
@RestController
@RequiredArgsConstructor
@RequestMapping("/children")
public class ChildrenController {

  private final ChildrenService childrenService;

  @Operation(summary = "Get child by ID")
  @GetMapping("/{childId}")
  public ChildDto getChildById(@PathVariable Long childId) {
    log.info("Getting child by ID: {}", childId);
    return childrenService.getChildById(childId);
  }

  @Operation(summary = "Get children")
  @GetMapping
  public SearchResponse<ChildDto> getChildren(@Valid SearchRequest request) {
    log.info("Searching children by parameters: {}", request);
    return childrenService.getChildren(request);
  }
}
