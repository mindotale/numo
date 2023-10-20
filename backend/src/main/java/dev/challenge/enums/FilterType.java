package dev.challenge.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FilterType {
  EQUALS("="),
  GREATER_THAN(">"),
  LESS_THAN("<"),
  GREATER_THAN_OR_EQUAL_TO(">="),
  LESS_THAN_OR_EQUAL_TO("<=");

  @JsonValue private final String operator;
}
