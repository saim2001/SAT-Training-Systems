import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.List;


public class Session_3_Assignment {
    public static void main(String[] args){
        By_Xpaths("google_chrome\\chromedriver.exe",
                "https://rahulshettyacademy.com/AutomationPractice/",
                "Saim",
                "Java");
    }
    public static void  By_Xpaths(String Driver_path,String Page_url,String name,String anything){
        System.setProperty("webdriver.chrome.driver",Driver_path);
        WebDriver driver=new ChromeDriver();
        driver.navigate().to(Page_url);
        driver.findElement(By.xpath("//fieldset//input[@class=\"inputs\"]")).sendKeys(name);
        driver.findElement(By.xpath("//input[@id=\"alertbtn\"]")).click();
        try{
            Thread.sleep(1000);
        }
        catch (Exception e){

        }
        driver.switchTo().alert().accept();
        try{
            Thread.sleep(1000);
        }
        catch (Exception e){

        }
        driver.findElement(By.xpath("//input[@id=\"confirmbtn\"]")).click();
        driver.switchTo().alert().accept();
        try{
            Thread.sleep(1000);
        }
        catch (Exception e){

        }
        driver.findElement(By.xpath("//input[@name=\"show-hide\"]")).sendKeys(anything);
        try{
            Thread.sleep(1000);
        }
        catch (Exception e){

        }
        driver.findElement(By.xpath("//input[@id=\"hide-textbox\"]")).click();
        try{
            Thread.sleep(1000);
        }
        catch (Exception e){

        }
        driver.findElement(By.xpath("//input[@id=\"show-textbox\"]")).click();

        WebElement table=driver.findElement(By.id("product"));
        List<WebElement> rows=table.findElements(By.tagName("tr"));
        int Count_rows= rows.size();
        for (int i = 1; i < Count_rows; i++){
            String Course= rows.get(i).findElements(By.tagName("td")).get(1).getText();
            System.out.println("Course: " + i + " " + Course);


        }
        driver.quit();



    }
}
