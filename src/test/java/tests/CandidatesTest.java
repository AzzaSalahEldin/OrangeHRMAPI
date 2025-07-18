package tests;

import api.CandidatesAPI;

import config.CandidateDataProvider;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Epic("OrangeHRM API")
@Feature("Recruitment")
public class CandidatesTest extends BaseTest {

    @Test(dataProvider = "candidateData", dataProviderClass = CandidateDataProvider.class)
    @Story("Add Candidate via API")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate adding multiple candidates using TestNG DataProvider")
    public void testAddCandidate(String firstName, String lastName, String emailPrefix) {
        String email = emailPrefix + System.currentTimeMillis() + "@example.com";

        Map<String, Object> candidatePayload = new HashMap<>();
        candidatePayload.put("firstName", firstName);
        candidatePayload.put("lastName", lastName);
        candidatePayload.put("email", email);
        candidatePayload.put("vacancyId", 1);

        Response response = CandidatesAPI.createCandidate(sessionCookie, candidatePayload);

        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Response: " + response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK for candidate creation");
    }
}
