package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MultiprofilePage extends BaseTest {
    @Step("Profil seçim ekranına yönlendirme")
    public void RedirectProfilesScreen() {
        driver.get("https://tvplus.com.tr/profil/secim");
    }

    @Step("Profil seç butonuna tıkla")
    public void SelectProfile() {
        By profiles = By.xpath("//div[@class='profile-item_avatar']");
        List<WebElement> profileElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(profiles));
        profileElements.get(profileElements.size() - 1).click();
    }

    @Step("profil sayısını al")
    public Integer getProfileCount() {
        List<WebElement> profileElements = driver.findElements(By.xpath("//div[@class='profile-item_avatar']"));
        return profileElements.size();
    }

    @Step("Bana özel sayfasına yönlendirilme kontrolü")
    public void CheckBanaOzel() {
        WebElement banaOzelElement = this.getWebElementWithWait("//a[@class='self-tab active']");
        System.out.println(banaOzelElement.getText());
        Assert.assertEquals(banaOzelElement.getText(), "Bana Özel");
    }

    @Step("Yeni kullanıcı butonuna tıklayın")
    public void ClickNewProfile() {
        WebElement newProfile = this.getWebElementWithWait("//div[@class='profile-item_avatar add-button']");
        newProfile.click();
    }

    @Step("Kullanıcı adı alanını doldur.")
    public void SetProfileName(String profileNameStr) {
        WebElement profileName = this.getWebElementWithWait("//input[@name='username']");
        profileName.click();
        profileName.clear();
        profileName.sendKeys(profileNameStr);
    }

    @Step("Onayla butonuna tıkla.")
    public void Approve() {
        WebElement approve = this.getWebElementWithWait("//button[@class='btn-multiprofile']");
        approve.click();
    }

    @Step("Avatar seç.")
    public void SelectAvatar() {
        List<WebElement> avatarList = driver.findElements(By.xpath("//div[@class='ant-col css-2rgkd4']"));
        avatarList.get(0).click();
        driver.findElement(By.xpath("//button[@class='btn-multiprofile ']")).click();
    }

    @Step("Profili kontrol et.")
    public void CheckProfile(String profileName) {
        List<WebElement> profileElements = driver.findElements(By.xpath("//span[@class='profile-item_name']"));
        Boolean flag = false;
        for(int i = 0; i<profileElements.size(); i++) {
           if (profileElements.get(i).getText().equals(profileName)) {
                flag = true;
                break;
           }
        }
        Assert.assertTrue(flag);
    }

    @Step("profil düzenle butonuna tıkla.")
    public void ClickProfileEdit() {
        WebElement ProfileButton = this.getWebElementWithWait("//button[@class='btn-multiprofile btn-choose-profile']");
        ProfileButton.click();
    }

    @Step("Profildeki Değişiklikleri Kaydet.")
    public void SaveChangesOnProfile() {
        driver.findElement(By.xpath("//i[@class='icon-arrow arrow-back']")).click();
    }

    @Step("Bu profili sil butonuna tıkla.")
    public void DeleteProfile() {
        WebElement deleteProfileElement = this.getWebElementWithWait("//input[@class='btn profile-delete' and @type='button']");
        deleteProfileElement.click();

        WebElement deleteProfileValidationButton = this.getWebElementWithWait("//button[@class='swal2-confirm swal2-styled' and @type='button']");
        deleteProfileValidationButton.click();
    }

    // Helper Methods

    private WebElement getWebElementWithWait(String xpath) {
        By byComponent = By.xpath(xpath);
        WebElement component = wait.until(ExpectedConditions.presenceOfElementLocated(byComponent));
        return component;
    }
}
