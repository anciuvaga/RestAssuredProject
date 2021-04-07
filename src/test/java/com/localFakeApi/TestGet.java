package com.localFakeApi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestGet {

    @Test
    public void testGet_01() {

        baseURI = "http://localhost:3000/";

        given()
                    .get("users")
                .then()
                    .statusCode(200)
                    .log().all();
    }

    @Test
    public void testGet_02() {
        baseURI = "http://localhost:3000/";

                given()
                    .param("name", "Automation")
                    .get("subjects")
                .then()
                    .statusCode(200)
                    .log().all();
    }

}