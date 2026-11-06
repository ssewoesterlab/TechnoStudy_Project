package TC04;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import Utility.Elements;
import Utility.MyFunc;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class TC04 extends BaseDriverParameter {
    @Test(groups = "Regression")
    public void Blog() {
        Elements elements = new Elements(driver);

        driver.get("https://techno.study/");

        elements.blogsButton.click();

        for (int i = 0; i < elements.blogsList.size(); i++) {

            elements = new Elements(driver);
            List<WebElement> blogs = elements.blogsList;

            WebElement blog = blogs.get(i);
            wait.until(ExpectedConditions.elementToBeClickable(blog));

            String anaSekme = driver.getWindowHandle();
            blog.click();
            MyFunc.Bekle(1);

            Set<String> yeniSekme = driver.getWindowHandles();

            if (yeniSekme.size() > 1) {
                for (String sekme : yeniSekme) {
                    if (!sekme.equals(anaSekme)) {
                        driver.switchTo().window(sekme);
                        break;
                    }
                }
            }

            Assert.assertTrue(driver.getCurrentUrl().contains("techno.study"), "Blog sayfası açılmadı!");

            if (yeniSekme.size() > 1) {
                driver.close();
                driver.switchTo().window(anaSekme);
            } else {
                driver.navigate().back();
            }
        }
    }
}
