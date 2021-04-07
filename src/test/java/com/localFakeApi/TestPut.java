package com.localFakeApi;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestPut {

    @Test
    public void testPut() {

        JSONObject request = new JSONObject();

        request.put("firstName", "Edward");
        request.put("lastName", "Smith");
        request.put("subjectId", "4" );


        baseURI = "http://localhost:3000/";

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
        .when()
                .put("users/6")
        .then()
                .statusCode(200)
                .log().all();
    }
}
