import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URL;

public class Script_1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","google_chrome\\chromedriver.exe");
        WebDriver driver= new ChromeDriver() ;
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        String Page_title=driver.getTitle();
        System.out.println(Page_title);
        driver.findElement(By.xpath("/html/body/header/div/button[2]")).click();
        driver.quit();


    }
}
