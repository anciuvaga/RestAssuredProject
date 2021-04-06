import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class TestGet02 {

    @Test
    public void test_05() {

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
