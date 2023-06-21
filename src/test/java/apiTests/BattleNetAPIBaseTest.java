package apiTests;

import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import services.Services;

import static io.restassured.RestAssured.*;

public class BattleNetAPIBaseTest {
    public RequestSpecification initRequest() {
        String token = given().relaxedHTTPSValidation()
                .header(HttpHeaders.AUTHORIZATION, Services.getProperty("authbattle.token"))
                .param("grant_type", "client_credentials").when()
                .post("https://oauth.battle.net/token").then().statusCode(HttpStatus.SC_OK).extract().body().path("access_token");
        baseURI = "https://eu.api.blizzard.com";
        return given().param("access_token", token);
    }
}
