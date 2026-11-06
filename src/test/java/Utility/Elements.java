package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Elements {

    public Elements(WebDriver driver) {
        PageFactory.initElements(driver,this);    }

    @FindBy(xpath = "//*[text()='APPLY NOW']")
    public WebElement applyNowButton;

    @FindBy(xpath = "//*[@placeholder='Full name']")
    public WebElement fullNameInputField;

    @FindBy(xpath = "//*[@placeholder='Email']")
    public WebElement emailInputField;

    @FindBy(xpath = "//*[@class='t-input-phonemask__select-flag']")
    public WebElement phoneFlagSelect;

    @FindBy(xpath = "//*[@class='t-input t-input-phonemask']")
    public WebElement phoneNumberInputField;

    @FindBy(xpath = "//*[@name='country']")
    public WebElement countySelect;

    @FindBy(xpath = "//*[@name='course']")
    public WebElement courseSelect;

    @FindBy(xpath = "//*[@name='survey']")
    public WebElement howDidYouButton;

    @FindBy(xpath = "//*[@name='promo code']")
    public WebElement promoCodeInputField;

    @FindBy(xpath = "//*[@name='Checkbox']//following::div")
    public WebElement agreeCheckBox;

    @FindBy(xpath = "//*[text()='Book a Call']")
    public WebElement bookACallButton;

    @FindBy(xpath = "//*[@id='tildaformsuccesspopuptext']")
    public WebElement successMessage;

    @FindBy(xpath = "//*[@class='t-form__errorbox-item']")
    public List<WebElement> errorMessages;

    @FindBy(xpath = "//a[@class='t-menu__link-item t966__tm-link']")
    public WebElement programMenu;

    @FindBy(xpath = "//div[text()='Software Development Engineer in Test']")
    public WebElement sdet;

    @FindBy(xpath = "//div[text()='Data Science Bootcamp']")
    public WebElement dataScienceBootcamp;

    @FindBy(xpath = "//div[text()='Artificial Intelligence']")
    public WebElement intelligence;

    @FindBy(xpath = "//div[text()='Android Developer Bootcamp']")
    public WebElement androidDeveloper;

    @FindBy(xpath = "(//div[@class='t966__menu-item-title t966__typo__menu_474856319 t-name'])[5]")
    public WebElement mastersProgram;

    @FindBy (xpath = "(//*[@class='t228__list_item'])[4]")
    public WebElement blogsButton;

    @FindBy (xpath = "//*[@class='js-feed t-feed t-feed_col']/ul/li")
    public List<WebElement> blogsList;

    @FindBy(xpath = "//*[text()='SIGN IN']")
    public WebElement signInButton;

    @FindBy(xpath = "//a[text()='Terms of Use']")
    public WebElement termOfUse;

    @FindBy(xpath = "//h2[contains(text(),'Choose a program')]")
    public WebElement chooseProgramText;

    @FindBy(xpath = "(//a[contains(text(),'Learn more')])[2]")
    public WebElement learnMoreButton1;

    @FindBy(xpath = "(//a[contains(text(),'Learn more')])[3]")
    public WebElement learnMoreButton2;

    @FindBy(xpath = "(//a[contains(text(),'Learn more')])[1]")
    public WebElement learnMoreButton3;

    @FindBy(xpath = "//div[@class='t420__logo t-title']")
    public WebElement technostudyButton;

    @FindBy(xpath = "//img[@class='t228__imglogo ']")
    public WebElement technostudyBackButton;

    @FindBy(xpath = "//footer//a[contains(@href, 'facebook') or contains(@href, 'instagram') or contains(@href, 'youtube') or contains(@href, 'linkedin')]")
    public WebElement footer;

    @FindBy(xpath = "//footer//a[contains(@href, 'facebook')]")
    public WebElement facebook;

    @FindBy(xpath = "//footer//a[contains(@href, 'instagram')]")
    public WebElement instagram;

    @FindBy(xpath = "//footer//a[contains(@href, 'youtube')]")
    public WebElement youtube;

    @FindBy(xpath = "//footer//a[contains(@href, 'linkedin')]")
    public WebElement linkedin;

}
