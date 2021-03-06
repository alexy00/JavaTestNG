package testclasses;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExtentReport {

    private WebDriver driver;
    private ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeClass() {
        String baseUrl = "http://www.letskodeit.com/";
        report = new ExtentReports("C://Users//Al//Desktop//logintest.html");  //<====file location
        test = report.startTest("Verify Welcome Text");
        driver = new ChromeDriver();
        test.log(LogStatus.INFO, "Browser Started...");
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser Maximized");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(LogStatus.INFO, "Web application opened");
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
        signupLink.click();
        test.log(LogStatus.INFO, "Clicked on signup link");

        WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        loginLink.click();
        test.log(LogStatus.INFO, "Clicked on login link");

        WebElement emailField = driver.findElement(By.id("memberLoginDialogemailInputinput"));
        emailField.sendKeys("test@email.com");
        test.log(LogStatus.INFO, "Enter email");

        WebElement passwordField = driver.findElement(By.id("memberLoginDialogpasswordInputinput"));
        passwordField.sendKeys("abcabc");
        test.log(LogStatus.INFO, "Enter password");


        WebElement goButton = driver.findElement(By.id("memberLoginDialogokButton"));
        goButton.click();
        test.log(LogStatus.INFO, "Clicked Go button");

        Thread.sleep(3000);

        WebElement welcomeText = null;

        try {
            welcomeText = driver.findElement(By.id("comp-iiqg1vggmemberTitle"));
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(welcomeText != null);
        test.log(LogStatus.PASS, "Verified Welcome Text");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        report.endTest(test);
        report.flush();
    }
}
