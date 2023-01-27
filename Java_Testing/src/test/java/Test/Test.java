package Test;
import Utils.PageFactory;
import Implementation.Implementation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test {

     static WebDriver driver = PageFactory.lauchWebBrowser("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    @org.testng.annotations.Test(priority = 0)
    public static void invalidLogin(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        By element_by = (By.xpath("(//div[@class='oxd-form-row']/descendant::input)[1]"));
        WebElement element= wait.until(ExpectedConditions.presenceOfElementLocated(element_by));

        Implementation.invalidLogin(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Implementation.missingLogin(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Implementation.missingUsernameLogin(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Implementation.missingPasswordLogin(driver);

    }
    @org.testng.annotations.Test(priority = 1)
    public static void Login(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Implementation.correctLogin(driver);
    }

    @org.testng.annotations.Test(priority = 2)
    public static void Quit(){
        driver.quit();
    }



}
