package dev.challenge.api.endpoint;

import dev.challenge.api.util.Common;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GroupEndpoints {
    public static final String GROUP_URL = "http://localhost:8080/api/groups";

    public static Response getGroups() {
        return given()
                .spec(Common.getRequestSpec())
                .when()
                .get(GROUP_URL);
    }
}
