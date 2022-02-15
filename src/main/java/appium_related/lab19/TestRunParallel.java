package appium_related.lab19;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class TestRunParallel extends BaseTestParallel{

    @Test
    public void test1(){
        getAndroidDriver();
//        Assert.fail(String.valueOf(new Date().getTime()));
    }
}
