package api;

import config.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class CandidatesAPI {

    public static Response createCandidate(String sessionCookie, Map<String, Object> payload) {
        return RestAssured.given()
                .baseUri(ConfigManager.get("base.url"))
                .basePath("/web/index.php/api/v2/recruitment/candidates")
                .header("Cookie", "orangehrm=" + sessionCookie)
                .contentType("application/json")
                .body(payload)
                .post();
    }
}
