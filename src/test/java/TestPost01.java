import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestPost01 {

    @Test
    public void testPost_01() {

/**
 * Adding a request body using map is shown below
 */

//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "Andrew");
//        map.put("job", "leader");
//        System.out.println(map);
//
//        JSONObject request = new JSONObject(map);
//        System.out.println(request);
//        System.out.println(request.toJSONString());

        /**
         * Adding a request using a JSONObject directly, json simple library
         */

        JSONObject request = new JSONObject();
        request.put("name", "Andrew");
        request.put("job", "leader");

        System.out.println(request);

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);
    }

}
