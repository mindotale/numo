package dev.challenge.api.endpoint;

import static io.restassured.RestAssured.given;

import dev.challenge.api.util.Common;
import io.restassured.response.Response;

public class MessagesEndpoints {
  public static final String MESSAGES_URL = "http://localhost:8080/api/messages";

  public static Response getMessages() {
    return given().spec(Common.getRequestSpec()).when().get(MESSAGES_URL);
  }
}
