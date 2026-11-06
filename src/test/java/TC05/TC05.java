package TC05;

import Utility.BaseDriverParameter;
import Utility.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TC05 extends BaseDriverParameter {
    @Test (groups = "Smoke Test")
    public void TC05(){

        Elements elements=new Elements(driver);


        driver.get("https://techno.study/");
        Actions a = new Actions(driver);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));


        wait1.until(ExpectedConditions.visibilityOf(elements.footer));
        a.moveToElement(elements.footer).perform();

        List<WebElement> footerList = driver.findElements(By.tagName("footer"));

        if (footerList.size()>0){
            System.out.println("Bu websitesinde footer vardır");
        } else {
            System.out.println("Bu websitesinde footer yoktur.");
        }


        elements.facebook.click();
        ArrayList<String> fTab = new ArrayList<String>(driver.getWindowHandles());
        String facebookTab = fTab.get(1);
        driver.switchTo().window(facebookTab);
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("technostudybootcamps"), "Facebook linki hatalıdır");
        driver.close();
        driver.switchTo().window(fTab.get(0));


        elements.instagram.click();
        ArrayList<String> insTab = new ArrayList<String>(driver.getWindowHandles());
        String instagramTab = insTab.get(1);
        driver.switchTo().window(instagramTab);
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("techno.study"), "Facebook linki hatalıdır");
        driver.close();
        driver.switchTo().window(insTab.get(0));

        elements.youtube.click();
        ArrayList<String> youTab = new ArrayList<String>(driver.getWindowHandles());
        String youtubeTab = youTab.get(1);
        driver.switchTo().window(youtubeTab);
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("TechnoStudyInc"), "Facebook linki hatalıdır");
        driver.close();
        driver.switchTo().window(youTab.get(0));

        elements.linkedin.click();
        ArrayList<String> linkTab = new ArrayList<String>(driver.getWindowHandles());
        String linkedinTab = linkTab.get(1);
        driver.switchTo().window(linkedinTab);
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("techno-study-inc"), "Facebook linki hatalıdır");
        driver.close();
        driver.switchTo().window(linkTab.get(0));


        System.out.println("Test başarı ile sonuçlanmıştır");
    }
}
