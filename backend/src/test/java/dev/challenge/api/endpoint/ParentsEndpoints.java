package dev.challenge.api.endpoint;

import static io.restassured.RestAssured.given;

import dev.challenge.api.util.Common;
import io.restassured.response.Response;

public class ParentsEndpoints {
  public static final String PARENTS_ENDPOINT = "http://localhost:8080/api/parents";

  public static Response getParents() {
    return given().spec(Common.getRequestSpec()).when().get(PARENTS_ENDPOINT);
  }
}
