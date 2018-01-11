package testclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CCPageFactory;
import utilities.GenericMethods;

import java.util.concurrent.TimeUnit;

public class TryCatchVariousOutcomes {

    @DataProvider(name="credit_Cards")
    public Object[][] grtdata(){
        return new Object[][]{
                {"5105105105105100", "333"},
                {"510510510510510", "333"},  // <=== Bad Master
                {"4012888888881881", "333"},
                {"371449635398431","3333"}
        };
    }

    private WebDriver driver;
    private String URL2;
    private CCPageFactory formCC;
    private GenericMethods gm;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        URL2 = "https://www.lifecellskin.com/es/order.php?tempOrderId=B1B2781B5735317EA5029CE07644D9D0";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        formCC = new CCPageFactory(driver);
        gm = new GenericMethods(driver);

    }

    @Test(dataProvider = "credit_Cards")

    public void credit_rcard(String input1, String input2) throws Exception {
        driver.get(URL2);
        formCC = new CCPageFactory(driver);

        formCC.FillCC(input1, input2);


        try {
            gm.waitForElement(By.cssSelector(".inner-wrapper>span"), 20);
            Assert.assertTrue(driver.getCurrentUrl().contains("es/success"));
            System.out.println("Success page is loaded  <===========\n");
        } catch (AssertionError e) {
            System.out.println("The Success page is Not loaded");

            try {
                WebElement error_msg = driver.findElement(By.cssSelector("#error-message-display"));
                Assert.assertTrue(error_msg.isDisplayed());
                System.out.println("Error msg is displayed   <===========\n");
            } catch (AssertionError a) {
                System.out.println("The Success page is Not loaded");   // Never prints

            }

        }
    }
    @AfterClass
    public void tearDown() throws Exception {

        driver.close();
        driver.quit();
    }

}
