package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest extends Data{

    public static WebDriver driver;
    public static WebDriverWait wait;

    //BEFORE
    @BeforeClass
    public static void beforeTest(){
        if (browser.equals("Edge")){
            driver = new EdgeDriver();
        }
        else if (browser.equals("Firefox")){
            driver = new FirefoxDriver();
        }
        else {
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://tvplus.com.tr");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    //AFTER
    @AfterClass
    public static void afterTest(){
        driver.quit();
    }

}
