package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTool {
    public static void SuccessMessageValidation()
    {
        WebElement msgLabel=BaseDriver.driver.findElement(By.cssSelector("[class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));
    }
}
