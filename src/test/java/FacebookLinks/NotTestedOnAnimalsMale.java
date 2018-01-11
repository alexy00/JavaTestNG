package FacebookLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.GenericMethods;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NotTestedOnAnimalsMale {

    @DataProvider(name="URLsDesk")
    public Object[][] grtdata(){
        return new Object[][]{
                {"http://www.lifecellskin.com/ExclusiveOffer/index-nov-fb.php"},
                {"http://www.lifecellskin.com/ExclusiveOffer/index-nov-fb-test1.php"},




        };
    }

    private WebDriver driver;
    private String URL;
    private GenericMethods gm;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        gm = new GenericMethods(driver);

    }

    @Test(dataProvider = "URLsDesk")  //<= add

    public void blackRabbitLink(String input1) throws Exception {
        URL = input1;

        driver.get(URL);
        String parentHandle = driver.getWindowHandle();

        WebElement cruelty_free = driver.findElement(By.xpath("//img[@class='cp-logo'][@src='/offers/mobile/images/nov-men/not-tested.png']"));
        cruelty_free.click();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {    //SwitCh to another handle
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                Assert.assertTrue(driver.getCurrentUrl().contains("shopcrueltyfree"));
                driver.close();
                break;

            }
        }
        driver.switchTo().window(parentHandle);



    }
    @AfterClass
    public void tearDown() throws Exception {

        driver.close();
        driver.quit();
    }
}
