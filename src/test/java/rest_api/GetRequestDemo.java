package rest_api;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestDemo {
    /***
     * 	Given I have this information
        When I perform this action
        Then this should be the output
     */
    //http://www.lifecellskin.com/offers/images/nov-woman17/DARK-SPOT-clean.gif

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://www.lifecellskin.com";
        RestAssured.basePath = "/offers/images/nov-woman17";
    }

    @Test
    public void statusCodeVerification() {
        given()
                .when()
                .get("/DARK-SPOT-clean.gif")
                .then()
                .statusCode(200);
    }
}

