package TC07;

import Utility.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TechnoStudyPage {

    WebDriver driver;

    Elements elements=new Elements(driver);

    public TechnoStudyPage(WebDriver driver) {
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickLearnMoreButton(WebElement learnMoreButton) {
        scrollToElement(learnMoreButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", learnMoreButton);
    }

    public void clickTechnostudyButton() {
        scrollToElement(elements.technostudyButton);
        elements.technostudyButton.click();
    }

    public void clickTechnostudyBackButton() {
        elements.technostudyBackButton.click();
    }

    public boolean isChooseProgramTextVisible() {
        return elements.chooseProgramText.isDisplayed();
    }
}
