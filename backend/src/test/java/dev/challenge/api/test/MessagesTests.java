package dev.challenge.api.test;

import dev.challenge.api.endpoint.MessagesEndpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class MessagesTests {

  // @Test
  public void shouldGetMessages() {
    Response response = MessagesEndpoints.getMessages();
    Assertions.assertEquals(response.getContentType(), ContentType.JSON.toString());
  }
}
