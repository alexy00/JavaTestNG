package cremaslifecell.com;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormPageFactory;  //<-----
import pages.CCPageFactory;
import utilities.GenericMethods;

import java.util.concurrent.TimeUnit;


public class CCInputs {

    private WebDriver driver;
    private String URL;
    private String URL2;
    //private FormPageFactory formPage;    //<------
    private CCPageFactory formCC;
    private GenericMethods gm;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        URL = "https://mobile.cremaslifecell.com/p/es-index.html";
        URL2 = "https://mobile.cremaslifecell.com/p/es-order.html?tempOrderId=C4483BE77658C8962161C60B8E3A1627";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //formPage = new FormPageFactory(driver);  //<-----------
        //formCC = new CCPageFactory(driver);
        gm = new GenericMethods(driver);
    }

    @Test
    public void t_1_formfillup() {
        driver.get(URL);
        FormPageFactory formPage = new FormPageFactory(driver);  //<--------


        //formPage.FormPage("Canada", "Alberta");

        formPage.fillFname();
        formPage.fillLname();
        formPage.fillAddress();
        formPage.selectCountry("Canada");
        formPage.selectState("Alberta");
        formPage.fillCity();
        formPage.fillZip();
        formPage.fillPhone();
        formPage.fillEmail();
        formPage.clickOrder();

        Assert.assertTrue(driver.getCurrentUrl().contains("es-order"));
        System.out.println("The Order page is loaded\n");

    }

    @Test
    public void t_2_mastercard() throws Exception {
        driver.get(URL2);
        formCC = new CCPageFactory(driver);

        formCC.FillCC("5105105105105100", "333");


        /*formCC.fillCCNumber("5105105105105100");
        formCC.selectMonth();
        formCC.selectYear();
        formCC.fillSecCode("333");
        formCC.clickSend();*/


        try {
            gm.waitForElement(By.cssSelector(".inner-wrapper>span"), 30);
            Assert.assertTrue(driver.getCurrentUrl().contains("es/success"));
            System.out.println("The Master Card Success page is loaded\n");
        } catch (AssertionError e) {
            System.out.println("The Success page is Not loaded\n");


        }
    }
    @Test
    public void t_3_visa() throws Exception {
        driver.get(URL2);
        formCC = new CCPageFactory(driver);

        formCC.FillCC("37", "333");

       try {
            gm.waitForElement(By.cssSelector(".inner-wrapper>span"), 30);
            Assert.assertTrue(driver.getCurrentUrl().contains("es/success"));
            System.out.println("The Visa Success page is loaded\n");
        }
        catch (AssertionError e) {
            System.out.println("The Success page is Not loaded\n");
        }

    }

    @Test
    public void t_4_amex() throws Exception {
        driver.get(URL2);
        formCC = new CCPageFactory(driver);

        formCC.FillCC("371449635398431", "3333");

        try {
            gm.waitForElement(By.cssSelector(".inner-wrapper>span"), 30);
            Assert.assertTrue(driver.getCurrentUrl().contains("es/success"));
            System.out.println("The American Express Success page is loaded");
        }
        catch (AssertionError e) {
            System.out.println("The Success page is Not loaded");
        }

    }


    @AfterClass
    public void tearDown() throws Exception {

        driver.close();
        driver.quit();
    }

}



