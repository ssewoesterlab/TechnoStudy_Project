package TC02;

import Utility.BaseDriver;
import Utility.Elements;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TC02 extends BaseDriver {

    @Test(groups = "Smoke Test")

    public void TC02() {
        driver.get("https://techno.study/");

        Elements elements=new Elements(driver);
        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://techno.study/", driver.getCurrentUrl());
        wait.until(ExpectedConditions.visibilityOf(elements.signInButton)).click();
        wait.until(ExpectedConditions.urlToBe("https://campus.techno.study/"));




    }

}
