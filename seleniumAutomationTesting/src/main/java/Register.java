import Base.BaseTest;
import Pages.LoginPage;
import Pages.RegisterPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Register extends BaseTest {
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @org.testng.annotations.Test(description = "Sisteme kayıtlı olan kullanıcı ile yeniden kullanıcı oluşturma ")
    public void Test7() {
        loginPage.ClickRegister();
        registerPage.fillFirstName("Doğan Akdeniz");
        registerPage.fillEmail("dgnkdnz@gmail.com");
        registerPage.fillPhone("543811916");
        registerPage.FillPassword("Tv543543");
        registerPage.ConfirmationButton();
        registerPage.RegisterButton();
        registerPage.ErrorMessageCheck("TV+'a zaten üyesiniz. Üye girişi yaparak TV+'ı kullanabilirsiniz. (Hata Kodu: 1010)");
    }

    @org.testng.annotations.Test (description = "Ad, soyad, Email, telefon numarası, alanlarının boş gönderilmesi")
    public void Test8()
    {
        loginPage.ClickRegister();
        registerPage.FillfirstWithWrongData("");
        registerPage.FillEmailWithWrongData("");
        registerPage.FillPhoneWithWrongData("");
        registerPage.FillPasswordWithWrongData("");
        registerPage.ConfirmationButton();
        registerPage.RegisterButton();
        registerPage.GetAllErrorMessages();
    }

    @org.testng.annotations.Test(description = "Şifre alanının minimum maksimum karekter,")
    public void Test9()
    {
        loginPage.ClickRegister();
        registerPage.fillFirstName("merve akdeniz");
        registerPage.fillEmail("dgnkdnz@gmail.com");
        registerPage.fillPhone("5375529999");
        registerPage.FillPassword("2s4");
        registerPage.ConfirmationButton();
        registerPage.RegisterButton();
        registerPage.ErrorMessage("Şifreniz, içerisinde en az bir büyük harf, bir küçük harf ve bir de sayı içermelidir.");

    }

    @Test(description = "Şifre alanının tekrar eden sayı ve tekrar eden karakter kontrolü")
    public void Test10()
    {
        loginPage.ClickRegister();
        registerPage.fillFirstName("merve akdeniz");
        registerPage.fillEmail("dgnkdnz@gmail.com");
        registerPage.fillPhone("5375529999");
        registerPage.FillPassword("aaaaaaaaA1");
        registerPage.ConfirmationButton();
        registerPage.RegisterButton();
        registerPage.ErrorMessage("Girilen şifre karekter tekrarı içermemelidir. (11111 - aaaaa)");
    }

    @Test(description = "Kullanıcı oluşturma kontrolü")
    public void Test11()
    {
        loginPage.ClickRegister();
        registerPage.fillFirstName("merve Akdeniz");
        registerPage.fillEmail("dgnkdnzz@gmail.com");
        registerPage.fillPhone("099999966");
        registerPage.FillPassword("224e581C");
        registerPage.ConfirmationButton();
        registerPage.RegisterButton();
        registerPage.ConfirmationMessage("Kayıt işleminizi tamamlamak için lütfen 5099999966 numaralı telefona sms ile gönderilen 6 haneli doğrulama kodunu giriniz:");

    }
}
