package com.localFakeApi;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestPatch {

    @Test
    public void testPatch() {

        JSONObject request = new JSONObject();

        request.put("firstName", "Luigi");

        baseURI = "http://localhost:3000/";

                given()
                    .header("Content-Type", "application/json")
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(request.toJSONString())
                .when()
                    .patch("users/5")
                .then()
                    .statusCode(200)
                    .log().all();
    }
}
