import Base.BaseTest;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class Login extends BaseTest {

    @Test(description = "sisteme kayıtlı olmayan kullanıcı ile giriş yap.")
    public void Test1()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.RedirectLogin();
        loginPage.FillPhone("5438119165");
        loginPage.FillPassword("T54354v");
        loginPage.ClickLoginButton();
        loginPage.ErrorMessageCheck("TV+'ta kayıtlı kullanıcınız bulunmamaktadır, lütfen Üye Ol ekranından kayıt olun. (Hata Kodu: 1000).");
    }

    @Test(description = "Telefon numarası alanının eksik gönderilmesi kontrolü")
    public void Test2()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.RedirectLogin();
        loginPage.FillPhone("12");
        loginPage.FillPassword("T54354v");
        loginPage.ClickLoginButton();
        loginPage.ErorMessage("Telefon numaranız başında 0 olmadan 10 haneli olmalıdır.");
    }

    @Test(description = "Şifre alanının boş gönderilmesi kontrolü")
    public void Test3()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.RedirectLogin();
        loginPage.FillPhone("5438119166");
        loginPage.FillPasswordWithWrongData("");
        loginPage.ErorMessage("Lütfen şifrenizi giriniz.");
    }

    @Test(description = "Hatalı telefon numarası ve doğru şifre kontrolü")
    //Hatalı telefon numarası ve doğru şifre kontrolü//

    public void Test4()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.RedirectLogin();
        loginPage.FillPhone("5438119166");
        loginPage.FillPassword("TV543543");
        loginPage.ClickLoginButton();
        loginPage.ErrorMessageCheck("TV+'ta kayıtlı kullanıcınız bulunmamaktadır, lütfen Üye Ol ekranından kayıt olun. (Hata Kodu: 1000).");
    }

    @Test(description = "Doğru telefon numarası ve hatalı şifre kontrolü")

    public void Test5()
    {
        LoginPage loginPage = new LoginPage();
        loginPage.RedirectLogin();
        loginPage.FillPhone("5543811916");
        loginPage.FillPassword("TV5432343e345");
        loginPage.ClickLoginButton();
        loginPage.ErrorMessageCheck("Giriş denemeniz başarısız oldu, telefon numarası ve şifrenizi kontrol ediniz. Sorun devam ederse müşteri hizmetlerini (05325320000) arayabilirsiniz. (Hata Kodu: 5102).");
    }

    @Test(description = "Sisteme kayıtlı olan kullanıcı ile giris yap.")
    public void Test6() {
        LoginPage loginPage = new LoginPage();
        loginPage.RedirectLogin();
        loginPage.FillPhone("5078601378");
        loginPage.FillPassword("224E581c");
        loginPage.ClickLoginButton();
        loginPage.AccessControl("Profil Seçin");
    }
}
