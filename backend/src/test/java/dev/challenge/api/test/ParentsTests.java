package dev.challenge.api.test;

import dev.challenge.api.endpoint.ParentsEndpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class ParentsTests {

    // @Test
    public void shouldGetParents() {
        Response response = ParentsEndpoints.getParents();
        Assertions.assertEquals(response.getContentType(), ContentType.JSON.toString());
    }
}
