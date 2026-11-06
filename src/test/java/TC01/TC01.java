package TC01;

import Utility.BaseDriverParameter;
import Utility.Elements;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends BaseDriverParameter {
    @Test (groups = "Smoke Test")
    public void dropDownMenu(){

        driver.get("https://techno.study/");

        Elements elements = new Elements(driver);
        elements.programMenu.click();
        MyFunc.Bekle(1);
        elements.sdet.click();
        MyFunc.Bekle(1);
        elements.programMenu.click();
        elements.dataScienceBootcamp.click();
        MyFunc.Bekle(1);
        elements.programMenu.click();
        elements.intelligence.click();
        MyFunc.Bekle(1);
        elements.programMenu.click();
        elements.androidDeveloper.click();
        MyFunc.Bekle(1);
        elements.programMenu.click();
        elements.mastersProgram.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='tn-atom']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='tn-atom']")).isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='tn-atom']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='tn-atom']")).isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='tn-atom']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='tn-atom']")).isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='tn-atom']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='tn-atom']")).isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='tn-atom']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='tn-atom']")).isDisplayed());

    }
}
