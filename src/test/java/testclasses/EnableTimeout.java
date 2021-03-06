package testclasses;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EnableTimeout {

    @BeforeClass
    public void setUp() {
        System.out.println("before class");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("after class");
    }

    @Test(enabled=false)  // will disable the test
    public void testMethod1() {
        System.out.println("testMethod1");
    }

    @Test(timeOut=300)  // for performance test timeout constrain. if timeout < 200 mills = test will fail
    public void testMethod2() throws InterruptedException {
        System.out.println("testMethod2");
        Thread.sleep(200);
    }
}
