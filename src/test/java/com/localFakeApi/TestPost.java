package com.localFakeApi;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestPost {

    @Test
    public void testPost() {

        JSONObject request = new JSONObject();
        request.put("firstName", "Alvaro");
        request.put("lastName", "Perez");
        request.put("subjectId", "3");

        baseURI = "http://localhost:3000/";

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
        .when()
                .post("users")
        .then()
                .statusCode(201)
                .log().all();
    }
}
