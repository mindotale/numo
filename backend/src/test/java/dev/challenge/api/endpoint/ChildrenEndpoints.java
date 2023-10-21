package dev.challenge.api.endpoint;

import static io.restassured.RestAssured.given;

import dev.challenge.api.util.Common;
import io.restassured.response.Response;

public class ChildrenEndpoints {
  public static final String CHILDREN_URL = "http://localhost:8080/api/children";

  public static Response getChildren() {
    return given().spec(Common.getRequestSpec()).when().get(CHILDREN_URL);
  }
}
