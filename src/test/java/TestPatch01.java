import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPatch01 {

    @Test
    public void testPatch_01() {

        JSONObject request = new JSONObject();
        request.put("name", "John");
        request.put("job", "master");


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
