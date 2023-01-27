package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageFactory {
    public static WebDriver lauchWebBrowser(String URL){
        WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        return driver;
    }
}
