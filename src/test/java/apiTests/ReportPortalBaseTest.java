package apiTests;

import io.restassured.specification.RequestSpecification;
import services.Services;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class ReportPortalBaseTest {
    public RequestSpecification initRequest(){
        baseURI = "https://reportportal.epam.com/api/v1/";
        return given().auth().oauth2(Services.getProperty("authrp.token"))
                .headers(Map.of("accept", "*/*", "Content-Type", "application/json"));
    }
}
