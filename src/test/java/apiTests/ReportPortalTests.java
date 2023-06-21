package apiTests;

import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReportPortalTests extends ReportPortalBaseTest {

    @Test
    @Description("Checks if creation and deleting of the dashboard works properly")
    public void createAndDeleteDashboardTest() {
        SoftAssertions softAssertions = new SoftAssertions();
        JSONObject requestBody = new JSONObject();
        requestBody.put("description", "Test Description");
        requestBody.put("name", "TestName");
        requestBody.put("share", "true");
        initRequest().body(requestBody.toString()).post("anton_berkov_personal/dashboard")
                .then().statusCode(HttpStatus.SC_CREATED);
        List<Integer> idList = initRequest().get("anton_berkov_personal/dashboard").then().statusCode(HttpStatus.SC_OK).extract().body()
                .path("content.id");
        String testName =  initRequest().get("anton_berkov_personal/dashboard/"+ idList.get(0)).then().statusCode(HttpStatus.SC_OK).extract().body()
                .path("name");
        softAssertions.assertThat(testName).as("Dashboard name").isEqualTo("TestName");
        initRequest().delete("anton_berkov_personal/dashboard/" + idList.get(0)).then().statusCode(HttpStatus.SC_OK);
        initRequest().get("anton_berkov_personal/dashboard/"+ idList.get(0)).then().statusCode(HttpStatus.SC_NOT_FOUND);
        softAssertions.assertAll();
    }

}
