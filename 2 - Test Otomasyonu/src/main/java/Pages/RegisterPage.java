package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage extends BaseTest {

    @Step("Ad soyad alanına metin girişi sağlanır.")
   public void fillFirstName(String text){
       WebElement firstNameElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/form/div/div[1]/input"));
       firstNameElement.clear();
       firstNameElement.sendKeys(text);
   }

    @Step("Email alanına metin girişi sağlanır.")
    public void fillEmail(String text){
       WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/form/div/div[2]/input"));
       emailElement.sendKeys(text);

   }

    @Step("Telefon numarası alanına numara girişi sağlanır.")
    public void fillPhone(String text){
        WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/form/div/div[3]/input"));
        phoneElement.sendKeys(text);

    }

    @Step("Şifre alanına metin girişi sağlanır.")
    public void FillPassword(String text){
        WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/form/div/div[4]/input"));
        passwordElement.sendKeys(text);
    }

    @Step("Onay butonuna tıklanır.")
    public void ConfirmationButton(){
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/form/div/div[5]/label[1]/span")).click();
    }

    @Step("Register butonuna tıklanır.")
    public void RegisterButton(){
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/form/div/button")).click();
   }

    @Step("Error mesaj kontrolü.")
    public void ErrorMessageCheck(String massege) {
        String text =  driver.findElement(By.id("swal2-html-container")).getText();
        Assert.assertEquals(text, massege);
        System.out.println(text);
   }

    @Step("Error mesaj kontrolü.")
    public void ErrorMessage(String massege){
        String text =  driver.findElement(By.xpath("//span[@class='error__message']")).getText();
        Assert.assertEquals(text, massege);
        System.out.println(text);
   }

    @Step("Onay mesajı kontrolü. ")
    public void ConfirmationMessage(String massege){
        String text = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[2]/div/div[2]/p")).getText();
        Assert.assertEquals(text, massege);
        System.out.println(text);
    }

    @Step("Yanlış ad soyad doldur.")
    public void FillfirstWithWrongData(String text){
        WebElement firstNameElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/form/div/div[1]/input"));
        firstNameElement.click();
        firstNameElement.sendKeys("a");
        firstNameElement.sendKeys(Keys.BACK_SPACE);
        firstNameElement.sendKeys(text);

    }

    @Step("Yanlış Email doldur.")
    public void FillEmailWithWrongData(String text){
        WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/form/div/div[2]/input"));
        emailElement.click();
        emailElement.sendKeys("m");
        emailElement.sendKeys(Keys.BACK_SPACE);
        emailElement.sendKeys(text);

    }

    @Step("Yanlış telefon numarası doldur.")
    public void FillPhoneWithWrongData(String text){
        WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/form/div/div[3]/input"));
        phoneElement.click();
        phoneElement.sendKeys("5");
        phoneElement.sendKeys(Keys.BACK_SPACE);

    }

    @Step("Yanlış şifre doldur.")
    public void FillPasswordWithWrongData(String text){
        WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/form/div/div[4]/input"));
        passwordElement.click();
        passwordElement.sendKeys("3");
        passwordElement.sendKeys(Keys.BACK_SPACE);
    }

    @Step("Error mesaj kontrolü.")
    public void GetAllErrorMessages() {
        List<WebElement> errorList = driver.findElements(By.xpath("//span[@class='error__message']"));
        String[] expectedTexts = new String[] {
                "Ad ve Soyad girilmesi zorunludur.",
                "E-posta girilmesi zorunludur.",
                "Telefon numaranız başında 0 olmadan 10 haneli olmalıdır.",
                "Lütfen şifrenizi giriniz."
        };
        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(errorList.get(i).getText(), expectedTexts[i]);
            System.out.println(errorList.get(i).getText());
        }
    }
}
