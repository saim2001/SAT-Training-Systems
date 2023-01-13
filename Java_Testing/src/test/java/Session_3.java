import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;





public class Session_3 {
    public static void main(String[] args) {
        New();
    }

    static void New() {
        String Driver_path = "google_chrome\\chromedriver.exe";
        String Page_url = "https://rahulshettyacademy.com/AutomationPractice/";
        String Keys_to_send = "Saim";
        System.setProperty("webdriver.chrome.driver", Driver_path);
        WebDriver driver = new ChromeDriver();

        driver.navigate().to(Page_url);
        int count = driver.findElements(By.xpath("//select/option")).size();
        for (int i = 0; i < count; i++) {
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){

            }
            driver.findElements(By.xpath("//select/option")).get(i).click();
        }
        int Opt_count = driver.findElements(By.xpath("//label//input[@type=\"checkbox\"]")).size();
        for (int i = 0; i < Opt_count; i++) {
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){

            }
            driver.findElements(By.xpath("//label//input[@type=\"checkbox\"]")).get(i).click();
        }
    }
}
