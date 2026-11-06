package TC03;

import Utility.BaseDriverParameter;
import Utility.ConfigReader;
import Utility.Elements;
import Utility.MyFunc;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC03 extends BaseDriverParameter {

    @DataProvider(name = "bookingScenarios")
    public Object[][] bookingScenarios() {
        return new Object[][]{
                {"Test Test", "test@gmail.com", "111 111 1111", "Andorra", "SDET", "Other", "Test", true, true},
                {"Test Test", "test@gmail.com", "111 111 1111", "Andorra", "SDET", "", "Test", true, true},
                {"Test Test", "test@gmail.com", "111 111 1111", "Andorra", "SDET", "Other", "", true, true},

                {"", "test@gmail.com", "111 111 1111", "Andorra", "SDET", "Other", "Test", true, false},
                {"Test Test", "", "111 111 1111", "Andorra", "SDET", "Other", "Test", true, false},
                {"Test Test", "test@gmail.com", "", "Andorra", "SDET", "Other", "Test", true, false},
                {"Test Test", "test@gmail.com", "111 111 1111", "", "SDET", "Other", "Test", true, false},
                {"Test Test", "test@gmail.com", "111 111 1111", "Andorra", "", "Other", "Test", true, false},
                {"Test Test", "test@gmail.com", "111 111 1111", "Andorra", "SDET", "Other", "", false, false},
                {"", "", "", "", "", "", "", false, false},
                {"", "", "111 111 1111", "Andorra", "SDET", "Other", "Test", false, false},
                {"Test Test", "test@gmail.com", "111 111 1111", "", "", "Other", "Test", false, false},
                {"Test Test", "test@gmail.com", "111 111 1111", "", "", "Other", "Test", true, false},
                {"Test Test", "test@gmail.com", "111 111 1111", "Andorra", "", "Other", "Test", false, false},
                {"Test Test", "test@gmail.com", "111 111 1111", "Andorra", "", "Other", "", true, false},
                {"Test Test", "test@mailcom", "111 111 1111", "Andorra", "", "Other", "", true, false},
                {"Test Test", "test@mail.", "111 111 1111", "Andorra", "", "Other", "", true, false},
                {"Test Test", "testgmail.com", "111 111 1111", "Andorra", "", "Other", "", true, false},
                {"Test Test", "@gmail.com", "111 111 1111", "Andorra", "", "Other", "", true, false},
                {"Test Test", "test @gmail.com", "111 111 1111", "Andorra", "", "Other", "", true, false},
                {"Test Test", "test...@gmail.com", "111 111 1111", "Andorra", "", "Other", "", true, false},
                {"Test Test", ".test@gmail.com", "111 111 1111", "Andorra", "", "Other", "", true, false},
                {"Test Test", ".test@@gmail.com", "111 111 1111", "Andorra", "", "Other", "", true, false},
                {"", "", "", "", "", "", "Test", true, false},
                {"Test Test", "test@gmail.com", "111 111 1111", "Andorra", "SDET", "Other", "", false, false},
                {"   ", "test@gmail.com", "111 111 1111", "Andorra", "SDET", "Other", "", true, false},
                {"Test Test", "   ", "111 111 1111", "Andorra", "SDET", "Other", "", true, false},
                {"Test Test", "test@gmail.com", "   ", "Andorra", "SDET", "Other", "", true, false},
                {"Test Test", "a".repeat(245), "111 111 1111", "Andorra", "", "Other", "", true, false},
        };
    }

    @Test(dataProvider = "bookingScenarios", groups = "Smoke Test")
    public void testForm(String fullName, String email, String phoneNumber, String country,
                         String course, String aboutUs, String promoCode,
                         boolean terms, boolean success) {
        String url = ConfigReader.get("baseUrl");
        driver.get(url);
        int MyWait=0;
        Elements elements = new Elements(driver);
        SoftAssert softAssert = new SoftAssert();

        elements.applyNowButton.click();

        elements.fullNameInputField.clear();
        elements.fullNameInputField.sendKeys(fullName);

        elements.emailInputField.clear();
        elements.emailInputField.sendKeys(email);

        elements.phoneNumberInputField.clear();
        elements.phoneNumberInputField.sendKeys(phoneNumber);

        if (!country.isEmpty()) {
            new Select(elements.countySelect).selectByValue(country);
        }

        if (!course.isEmpty()) {
            new Select(elements.courseSelect).selectByValue(course);
        }

        if (!aboutUs.isEmpty()) {
            new Select(elements.howDidYouButton).selectByValue(aboutUs);
        }

        elements.promoCodeInputField.clear();
        elements.promoCodeInputField.sendKeys(promoCode);

        if (elements.agreeCheckBox.isSelected() != terms) {
            elements.agreeCheckBox.click();
        }

        elements.bookACallButton.click();

        if (success) {
            MyWait=10;
            wait.until(ExpectedConditions.visibilityOf(elements.successMessage));
            softAssert.assertTrue(elements.successMessage.isDisplayed());
        } else {
            MyWait=2;
            wait.until(driver -> elements.errorMessages.size() > 0);
            softAssert.assertTrue(elements.errorMessages.size() > 0);
        }


        MyFunc.Bekle(MyWait);
        new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();

        softAssert.assertAll();
    }
}
