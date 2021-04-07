package com.webApi;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class TestGet {



    @Test
    public void testGet01() {

        Response  response = get("https://reqres.in/api/users/2");
        System.out.println(response.toString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void testGet02() {

                given()
                    .get("https://reqres.in/api/users/2")
                .then()
                    .statusCode(200);

                given()
                    .get("https://reqres.in/api/users/2")
                .then()
                    .body("data.id", equalTo(2));
    }

    @Test
    public void testGet03() {

                given()
                    .get("https://reqres.in/api/users/2")
                .then()
                    .body("support.url", equalTo("https://reqres.in/#support-heading"));
    }

    @Test
    public void testGet04() {

                given()
                    .get("https://reqres.in/api/unknown")
                .then()
                    .body("data.id[0]", equalTo(1));
    }

    @Test
    public void testGet05() {

                 given()
//                .headers("Content-Type", "application/json")
//                .param("param", "param_value")
                    .get("https://reqres.in/api/users?page=2")
                .then()
                    .statusCode(200)
                    .body("data.id[1]", equalTo(8))
                    .body("data.first_name", hasItems("Michael", "Lindsay", "Tobias"))
                    .log().all();
    }
}

