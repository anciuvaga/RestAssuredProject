package com.localFakeApi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestDelete {

    @Test
    public void testDelete() {

        baseURI = "http://localhost:3000/";

                given()
                .when()
                    .delete("users/8")
                .then()
                    .statusCode(200)
                    .log().all();
    }
}
