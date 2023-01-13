import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.net.URL;


public class Script_2 {
    public static void main(String[] args){
        Open_tab();
    }
    static void Open_tab()  {
        String Driver_path="google_chrome\\chromedriver.exe";
        String Page_url="https://rahulshettyacademy.com/AutomationPractice/";
        System.setProperty("webdriver.chrome.driver",Driver_path);
        WebDriver driver=new ChromeDriver();
        driver.navigate().to(Page_url);
        driver.findElement(By.xpath("/html/body/header/div/a/button")).click();
        try {
            Thread.sleep(7000);
        }
        catch (Exception e){

        }
        String Page_title=driver.getTitle();
        System.out.println(Page_title);
        driver.quit();

    }
}