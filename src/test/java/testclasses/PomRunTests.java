package testclasses;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class PomRunTests {
    private WebDriver driver;

    @Parameters({"URL"})
    @BeforeClass
    public void setUp(String urlname) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(urlname);
        System.out.println("before class - browser setup");
    }


    @Test
    public void testMethod1() {

        System.out.println("testMethod1");
    }

    @Test
    public void testMethod2() {
        System.out.println("testMethod2");

    }

    @Test
    public void testMethod3() {
        System.out.println("testMethod3");
    }

    @Test
    public void testMethod4() {

        System.out.println("testMethod4");
    }

    @AfterClass
    public void cleanUp() {

        driver.quit();
        System.out.println("after class - browser close");
    }

}


