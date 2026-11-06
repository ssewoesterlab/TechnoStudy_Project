package TC08;

import Utility.BaseDriverParameter;
import Utility.Elements;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TC08 extends BaseDriverParameter {

    @Test (groups = "Smoke Test")

    public void termOfUse(){

        driver.get("https://techno.study/");

        Elements elements=new Elements(driver);

        elements.applyNowButton.click();


        elements.termOfUse.click();




    }
}
