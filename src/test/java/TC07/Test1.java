package TC07;

import Utility.BaseDriver;
import Utility.Elements;
import Utility.MyFunc;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 extends BaseDriver {

    @Test (groups = "Smoke Test")
    public void Test01(){
        TechnoStudyPage technoPage = new TechnoStudyPage(driver);
        Elements elements=new Elements(driver);

        // Sayfaya git
        driver.get("https://techno.study/");
        MyFunc.Bekle(2);

        // İlk 'Learn more' butonuna tıkla
        technoPage.clickLearnMoreButton(elements.learnMoreButton1);
        MyFunc.Bekle(2);

        // Sayfanın en altına in ve technostudy butonuna tıkla
        technoPage.clickTechnostudyButton();
        MyFunc.Bekle(2);

        // Sol üst kısımda bulunan technostudy tıklanır ve bir önceki sayfaya dönülür
        technoPage.clickTechnostudyBackButton();
        MyFunc.Bekle(2);

        // İkinci 'Learn more' butonuna tıkla
        technoPage.clickLearnMoreButton(elements.learnMoreButton2);
        MyFunc.Bekle(2);

        // Sayfanın en altına in ve technostudy butonuna tıkla
        technoPage.clickTechnostudyButton();
        MyFunc.Bekle(2);

        // Sol üst kısımda bulunan technostudy tıklanır ve bir önceki sayfaya dönülür
        technoPage.clickTechnostudyBackButton();
        MyFunc.Bekle(2);

        // Üçüncü 'Learn more' butonuna tıkla
        technoPage.clickLearnMoreButton(elements.learnMoreButton3);
        MyFunc.Bekle(2);

        // Sayfanın en altına in ve technostudy butonuna tıkla
        technoPage.clickTechnostudyButton();
        MyFunc.Bekle(2);

        // Sol üst kısımda bulunan technostudy tıklanır ve bir önceki sayfaya dönülür
        technoPage.clickTechnostudyBackButton();

        // Ana sayfa başarıyla yüklendi mi kontrol et
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(elements.chooseProgramText));
            Assert.assertTrue(technoPage.isChooseProgramTextVisible(), "Ana sayfa başarıyla yüklendi.");
        } catch (Exception e) {
            System.out.println("Ana sayfa yüklenemedi." + e.getMessage());
        }
    }
}
