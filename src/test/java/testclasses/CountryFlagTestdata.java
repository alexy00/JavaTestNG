package testclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.GenericMethods;
import test_data.TestData;          // <---import package if differrent

import java.util.concurrent.TimeUnit;

public class CountryFlagTestdata {



    private WebDriver driver;
    private String URL;
    private GenericMethods gm;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        URL = "http://www.lifecellskin.com/es/mobile/index-nov-fb2.php?desktop=true&country_test=";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        gm = new GenericMethods(driver);

    }

    @Test(dataProvider = "countries",dataProviderClass = TestData.class)  //<= add

    public void flag(String input1) throws Exception {
        driver.get(URL + input1 );



        try {
            WebElement flag = gm.waitForElement(By.cssSelector(".flag.flag"), 10);
            Assert.assertTrue(flag.isDisplayed());
            System.out.println("Flag is displayed");
        } catch (AssertionError e) {
            System.out.println("Flag is Not displayed");
        }
    }
    @AfterClass
    public void tearDown() throws Exception {

        driver.close();
        driver.quit();
    }

}


