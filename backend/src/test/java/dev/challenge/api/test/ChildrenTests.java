package dev.challenge.api.test;

import dev.challenge.api.endpoint.ChildrenEndpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class ChildrenTests {

  // @Test
  public void shouldGetChildren() {
    Response response = ChildrenEndpoints.getChildren();
    Assertions.assertEquals(response.getContentType(), ContentType.JSON.toString());
  }
}
