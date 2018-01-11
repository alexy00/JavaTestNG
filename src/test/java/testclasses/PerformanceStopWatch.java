package testclasses;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import utilities.GenericMethods;


import java.util.concurrent.TimeUnit;

public class PerformanceStopWatch {

    private WebDriver driver;
    private StopWatch watch = new StopWatch();
    private GenericMethods gm;

    @BeforeClass
    public void beforeClass() throws Exception {

        driver = new ChromeDriver();
        String baseUrl = "http://www.lifecellskin.com/";
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        gm = new GenericMethods(driver);

    }

    @Test
    public void searchFlight() throws Exception {

        WebElement order_button =  driver.findElement(By.cssSelector(".order-now-btn>a"));
        order_button.click();

        WebElement add_to_shopping = driver.findElement(By.xpath(".//section[@id='all-products-panel']/div/ul/li[1]/div[1]/a"));
        add_to_shopping.click();

        watch.start();
        WebElement cart = gm.waitForElement(By.id("CartDrawer"),20);
        double seconds = (double) watch.getTime() / 1000.0;
        watch.reset();
        System.out.println("Time taken to execute this method was: " + seconds + " seconds");

        //Assert.assertTrue(cart.isDisplayed());

        if (seconds > 15){
            System.out.println("Loading is taking too long");
        }
        else System.out.println("Loading time " + seconds + " is within expected parameters");

        //System.out.println("Time taken to execute this method was: " + seconds + " seconds");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
