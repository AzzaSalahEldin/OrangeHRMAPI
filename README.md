# 🧪 OrangeHRM REST API Test Automation Framework

This project is a TestNG-based REST Assured automation framework to test the OrangeHRM Recruitment API. It follows best practices like the Page Object Model (POM), uses a Config Manager for dynamic configuration, supports data-driven testing using TestNG DataProvider, and integrates Allure Reporting.

---

## 🔧 Tech Stack

- Java 17+
- TestNG
- REST Assured
- Selenium (for login to retrieve session cookie)
- Allure Reporting
- Maven
- Page Object Model (POM)
- GitHub
# Run Tests
   mvn test 
   mvn -Dtest=CandidatesTest test

# allure report 
allure generate allure-results --clean -o allure-report
allure open allure-report


