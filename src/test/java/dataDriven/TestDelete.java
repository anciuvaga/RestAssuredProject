package dataDriven;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

public class TestDelete extends DataClass {


//  @DataProvider(name = "DeleteData")
//     public Object[][] deleteData() {
//         return new Object[][] {{"Thomas", 7}};
//    }


    @Test(dataProvider = "DeleteData")
    public void testDelete( int id) {
        baseURI = "http://localhost:3000";

        when()
              .delete("users/" + id)
       .then()
              .statusCode(200)
              .log().all();

    }
    @Parameters({"userId"})
    @Test
    public void testDeleteWithParams(int userId){

        baseURI = "http://localhost:3000/";
        System.out.println("userId value is " + userId);
        when()
                .delete("users/" + userId)
        .then()
                .statusCode(200)
                .log().all();
    }
}
