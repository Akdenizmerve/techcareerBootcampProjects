import Base.BaseTest;
import Pages.LoginPage;
import Pages.MultiprofilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Multiprofile extends BaseTest {
    @org.testng.annotations.Test(description = "kullanıcıların kayıtlı profil ile giriş yapabilmesi.")
    public void Test12()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.RedirectLogin();
        loginPage.FillPhone("5078601378");
        loginPage.FillPassword("224E581c");
        loginPage.ClickLoginButton();

        MultiprofilePage multiprofilePage = new MultiprofilePage();
        multiprofilePage.SelectProfile();
    }

    @org.testng.annotations.Test(description = "kullanıcıların yeni profil oluşturması.")
    public void Test13()
    {
        // Login
        LoginPage loginPage = new LoginPage();
        loginPage.RedirectLogin();
        loginPage.FillPhone("5078601378");
        loginPage.FillPassword("224E581c");
        loginPage.ClickLoginButton();

        // Multiprofile
        String profileName = "MerveAkdeniz";
        MultiprofilePage multiprofilePage = new MultiprofilePage();
        multiprofilePage.ClickNewProfile();
        multiprofilePage.SetProfileName(profileName);
        multiprofilePage.Approve();
        multiprofilePage.SelectAvatar();
        multiprofilePage.CheckProfile(profileName);
    }

    @org.testng.annotations.Test(description = "kullanıcıların oluşturulan kullanıcıyı düzenlemesi.")
    public void Test14()
    {
        // Login
        LoginPage loginPage = new LoginPage();
        loginPage.RedirectLogin();
        loginPage.FillPhone("5078601378");
        loginPage.FillPassword("224E581c");
        loginPage.ClickLoginButton();

        // Multiprofile
        String profileName = "Akdeniz";
        MultiprofilePage multiprofilePage = new MultiprofilePage();
        multiprofilePage.ClickProfileEdit();
        multiprofilePage.SelectProfile();
        multiprofilePage.SetProfileName(profileName);
        multiprofilePage.SaveChangesOnProfile();
    }

    @org.testng.annotations.Test(description = "kullanıcıların oluşturulan profili silmesi.")
    public void Test15()
    {
        // Login
        LoginPage loginPage = new LoginPage();
        loginPage.RedirectLogin();
        loginPage.FillPhone("5078601378");
        loginPage.FillPassword("224E581c");
        loginPage.ClickLoginButton();

        MultiprofilePage multiprofilePage = new MultiprofilePage();
        multiprofilePage.ClickProfileEdit();
        multiprofilePage.SelectProfile();
        Integer profileCount = multiprofilePage.getProfileCount();
        multiprofilePage.DeleteProfile();
        Integer updatedProfileCount = multiprofilePage.getProfileCount();
        Assert.assertNotEquals(profileCount, updatedProfileCount);
    }
}
