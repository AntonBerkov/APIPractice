package tests;

import jdk.jfr.Description;
import model.Creature;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.*;

public class BattleNetAPITests extends BattleNetAPIBaseTest {
    Map<String, String> requestData;

    @Test
    @Description("Check if response contains given achievement")
    public void checkGivenAchievement() {
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
        softAssert.assertThat(responseBody.contains("Eye of the Storm")).as("Is response body contains given achievement").isTrue();
        softAssert.assertAll();
    }
    @Test
    @Description("Check if response contains all languages")
    public void checkIfResponseHasAllLanguages() {
        SoftAssertions softAssert = new SoftAssertions();
        Set<String> locales = Set.of("en_US", "es_MX",
                "pt_BR", "de_DE", "en_GB", "es_ES",
                "fr_FR", "it_IT", "ru_RU", "ko_KR", "zh_TW", "zh_CN");
        List<Map<String, String>> responseBody = initRequest()
                .param("namespace", "static-eu")
                .get("/data/wow/achievement-category/index")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body().path("categories.name");
        responseBody.stream().map(Map::keySet).forEach(set -> softAssert.assertThat(set).as("Does set contains all locales").isEqualTo(locales));
        softAssert.assertAll();
    }

    @Test
    @Description("Check if creature has given params")
    public void checkIfCreatureHasRightParams() {
        SoftAssertions softAssertions = new SoftAssertions();
        requestData = Map.of("namespace", "static-eu", "locale", "en_US");
        ResponseBodyExtractionOptions responseBodyExtractionOptions = initRequest()
                .params(requestData)
                .get("https://eu.api.blizzard.com/data/wow/creature/42722")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().body();
        Creature youngMastiff = new Creature(responseBodyExtractionOptions.path("name").toString(),
                responseBodyExtractionOptions.path("family.name").toString(),
                responseBodyExtractionOptions.path("type.name").toString());
        softAssertions.assertThat(youngMastiff.getName()).as("Creature Name").isEqualTo("Young Mastiff");
        softAssertions.assertThat(youngMastiff.getFamily()).as("Creature Family").isEqualTo("Hound");
        softAssertions.assertThat(youngMastiff.getType()).as("Creature type").isEqualTo("Beast");
        softAssertions.assertAll();
    }
}
