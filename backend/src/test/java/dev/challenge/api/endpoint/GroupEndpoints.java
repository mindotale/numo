package dev.challenge.api.endpoint;

import static io.restassured.RestAssured.given;

import dev.challenge.api.util.Common;
import io.restassured.response.Response;

public class GroupEndpoints {
  public static final String GROUP_URL = "http://localhost:8080/api/groups";

  public static Response getGroups() {
    return given().spec(Common.getRequestSpec()).when().get(GROUP_URL);
  }
}
