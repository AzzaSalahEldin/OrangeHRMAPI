package tests;

import config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected static String sessionCookie;
    protected static WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(ConfigManager.get("base.url") + "/web/index.php/auth/login");

        driver.findElement(By.name("username")).sendKeys(ConfigManager.get("username"));
        driver.findElement(By.name("password")).sendKeys(ConfigManager.get("password"));
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        try {
            Thread.sleep(4000); // Wait for login
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Cookie cookie = driver.manage().getCookieNamed("orangehrm");
        sessionCookie = cookie.getValue();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
