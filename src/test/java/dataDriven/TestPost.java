package dataDriven;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestPost extends DataClass {

//    @DataProvider(name = "DataForUserCreation")
//    public Object[][] createUser() {
//        Object[][] data = new Object[2][3];
//
//        data[0][0] = "Albert";
//        data[0][1] = "Einstein";
//        data[0][2] = 2;
//
//        data[1][0] = "Thomas";
//        data[1][1] = "Edison";
//        data[1][2] = 3;
//        return data;
//
//        return new Object [][] {
//                {"Isaac", "Newton", 4},
//                {"George", "Orwell", 5},
//                {"Graham", "Bell", 6}
//        };
//    }


    @Test(dataProvider = "DataForUserCreation")
    public void testPost(String firstName, String lastName, int subjectId) {

        JSONObject request = new JSONObject();
        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectId", subjectId);

        baseURI = "http://localhost:3000/";

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
        .when()
                .post("users/")
        .then()
                .statusCode(201)
                .log().all();
    }
}
