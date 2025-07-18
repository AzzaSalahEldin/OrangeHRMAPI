package config;

import org.testng.annotations.DataProvider;

public class CandidateDataProvider {

    @DataProvider(name = "candidateData")
    public Object[][] provideCandidateData() {
        return new Object[][] {
                {"John", "Doe", "john.doe"},
                {"Alice", "Smith", "alice.smith"},
                {"Bob", "Brown", "bob.brown"}
        };
    }
}
