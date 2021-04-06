import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestDelete01 {

    @Test
    public void testDelete01() {

        given()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204);
    }
}
