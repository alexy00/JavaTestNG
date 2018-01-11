package testclasses;

import org.testng.annotations.Test;
import appcode.SomeClassToTest;

public class TestAnnotation {

    @Test
    public void testmethod1(){
        SomeClassToTest obj = new SomeClassToTest();
        int result = obj.sumNumbers(1,2);
        System.out.println("Running Test -> testMethod1");
        System.out.println(result);


    }

    @Test
    public void testmethod2(){
        System.out.println("Running Test -> testMethod2");

    }

    @Test
    public void testmethod3(){
        System.out.println("Running Test -> testMethod3");

    }
}
