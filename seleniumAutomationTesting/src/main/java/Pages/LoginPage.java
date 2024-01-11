package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest {
   @Step("Cep telefonu alanına numara girişi sağlanır. ")
    public void FillPhone(String number){
        WebElement phoneElement = driver.findElement(By.name("phone"));
        phoneElement.clear();
        phoneElement.sendKeys(number);
    }

    @Step("Şifre alanına metin girişi sağlanır. ")
    public void FillPassword(String password){
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.click();
        passwordElement.sendKeys(password);
    }

    @Step("Şifre alanına yanlış metin girişi sağlanır. ")
    public void FillPasswordWithWrongData(String password){
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.click();
        passwordElement.sendKeys("b");
        passwordElement.sendKeys(Keys.BACK_SPACE);
        passwordElement.sendKeys(password);
    }


    @Step("TV Plus sitesine giriş yapılır. ")
    public void RedirectLogin() {
       driver.get("https://tvplus.com.tr/giris");
    }

    @Step("Register butonuna tıklanır. ")
    public void ClickRegister() {

       driver.findElement(By.cssSelector("[href=\"/yeni-kayit\"]")).click();
    }

    @Step("Login butonuna tıklanır. ")

    public void ClickLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[2]/form/button")).click();
    }

    @Step("Error mesaj kontrolü. ")
    public void ErrorMessageCheck(String massege) {
        WebElement errorMessage = this.getWebElementWithWait("//div[@class='swal2-html-container']");
        String text = errorMessage.getText();
        Assert.assertEquals(text, massege);
        System.out.println(text);
    }

    @Step("Erişim yapılabilme kontrolü ")
    public void AccessControl(String massege){
        String text =  driver.findElement(By.xpath("//div[@class='page-title']")).getText();
        Assert.assertEquals(text, massege);
        System.out.println(text);

    }

    @Step("Eror mesaj kontrolü. ")
    public void ErorMessage(String massege){
        String text =  driver.findElement(By.xpath("//span[@class='error__message']")).getText();
        Assert.assertEquals(text, massege);
        System.out.println(text);

    }

    // Helper Methods
    private WebElement getWebElementWithWait(String xpath) {
        By byComponent = By.xpath(xpath);
        WebElement component = wait.until(ExpectedConditions.presenceOfElementLocated(byComponent));
        return component;
    }

}
