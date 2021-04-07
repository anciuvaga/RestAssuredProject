package com.webApi;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestPut {

    @Test
    public void testPut01(){

        JSONObject request = new JSONObject();
        request.put("name", "Andrew");
        request.put("job", "boss");


                given()
                    .header("Content-Type", "application/json")
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(request.toJSONString())
                    .put("https://reqres.in/api/users/2")
                .then()
                    .statusCode(200)
                    .log().all();

    }

}
