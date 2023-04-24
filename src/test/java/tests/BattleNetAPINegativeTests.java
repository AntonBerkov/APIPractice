package tests;

import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class BattleNetAPINegativeTests extends BattleNetAPIBaseTest {
    Map<String, String> requestData;

    @Test
    @Description("Checks if response content doesn't contain cyrillic symbols")
    public void checkResponseDoesNotContainGivenLanguage() {
        SoftAssertions softAssert = new SoftAssertions();
        requestData = Map.of("namespace", "static-eu", "locale", "en_US");
        List<String> responseBody = initRequest()
                .params(requestData)
                .get("/data/wow/achievement-category/index")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body().path("categories.name");
        responseBody.forEach(text ->
                softAssert.assertThat(text.chars().mapToObj(Character.UnicodeBlock::of).anyMatch(Character.UnicodeBlock.CYRILLIC::equals)).isFalse());
        softAssert.assertAll();
    }

    @Test
    @Description("Checks if user can't access content without namespace")
    public void checkIfUserCantAccessContentWithoutNamespace() {
        initRequest()
                .get("/data/wow/achievement-category/index")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_FORBIDDEN);
    }
}
