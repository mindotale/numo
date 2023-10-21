package dev.challenge.api.endpoint;

import dev.challenge.api.util.Common;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ParentsEndpoints {
    public static final String PARENTS_ENDPOINT = "http://localhost:8080/api/parents";

    public static Response getParents() {
        return given()
                .spec(Common.getRequestSpec())
                .when()
                .get(PARENTS_ENDPOINT);
    }
}
