package FacebookLinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.GenericMethods;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class StudyLink {

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

    @Test(dataProvider = "URLs",dataProviderClass = FacebookURLs.class)  //<= add

    public void studyLinks(String input1) throws Exception {
        URL = input1;

        driver.get(URL);
        String parentHandle = driver.getWindowHandle();
        WebElement study_link = driver.findElement(By.cssSelector(".op-text>a"));
        study_link.click();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {    //SwitCh to another handle
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                Assert.assertTrue(driver.getCurrentUrl().contains("clinical-study"));
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
