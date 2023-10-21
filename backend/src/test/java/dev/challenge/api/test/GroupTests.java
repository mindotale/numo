package dev.challenge.api.test;

import dev.challenge.api.endpoint.GroupEndpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class GroupTests {

    // @Test
    public void shouldGetGroups() {
        Response response = GroupEndpoints.getGroups();
        Assertions.assertEquals(response.getContentType(), ContentType.JSON.toString());
    }
}
