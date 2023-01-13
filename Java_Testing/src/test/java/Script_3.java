import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Script_3 {
    public static void main(String[] args){
        Capture_alert();
    }
    static void Capture_alert(){
        String Driver_path="google_chrome\\chromedriver.exe";
        String Page_url="https://rahulshettyacademy.com/AutomationPractice/";
        String Keys_to_send="Saim";
        System.setProperty("webdriver.chrome.driver",Driver_path);
        WebDriver driver=new ChromeDriver();
        driver.navigate().to(Page_url);
        driver.findElement(By.id("name")).sendKeys(Keys_to_send);
        driver.findElement(By.id("alertbtn")).click();
        Alert alert = driver.switchTo().alert();
        String Alert_text=alert.getText();
        String Expected_text="Hello" + " " + Keys_to_send + ", share this practice page and share your knowledge";
        if(Alert_text.equals(Expected_text)) {
            System.out.println("Pass!");
        }
        else{
            System.out.println("Fail!");
        }

        alert.dismiss();
        driver.quit();
    }
}
