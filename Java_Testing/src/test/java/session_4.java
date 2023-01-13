import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URL;

public class session_4 {
    public static void main(String[] args){
        Open_chrome("https://www.saucedemo.com/","C:\\Users\\19b-048-se\\Desktop\\Java_Architecture\\Chrome_Driver\\chromedriver.exe");

    }
    public static void Open_chrome(String URL,String Driver_path){
        System.setProperty("webdriver.chrome.driver", Driver_path);
        WebDriver driver=new ChromeDriver();
        driver.navigate().to(URL);
        driver.findElement(By.id("user-name")).sendKeys("saim");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){

        }
        driver.findElement(By.id("user-name")).clear();

        driver.findElements(By.className("input_error")).get(0).sendKeys("rao");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){

        }
        driver.findElements(By.className("input_error")).get(0).clear();
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){

        }





        driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id=\"login-button\"]")).click();
        driver.findElement(By.xpath("//img[@src=\"/static/media/sauce-backpack-1200x1500.34e7aa42.jpg\"]")).click();
        WebElement price=driver.findElement(By.xpath("//div[@class=\"inventory_details_price\"]"));
        String price_txt=price.getText();
        System.out.println(price_txt);
        driver.findElement(By.className("btn_inventory")).click();
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){

        }

        driver.findElement(By.className("shopping_cart_link")).click();
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){

        }
        driver.findElement(By.className("checkout_button")).click();
        driver.findElement(By.id("first-name")).sendKeys("Saim");
        driver.findElement(By.id("last-name")).sendKeys("Rao");
        driver.findElement(By.id("postal-code")).sendKeys("75550");
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){

        }
        driver.findElement(By.id("continue")).click();
        System.out.println("Payment information: " + driver.findElements(By.className("summary_value_label")).get(0).getText());
        System.out.println("Shipping information: " + driver.findElements(By.className("summary_value_label")).get(1).getText());
        System.out.println(driver.findElement(By.className("summary_subtotal_label")).getText());
        System.out.println(driver.findElement(By.className("summary_tax_label")).getText());
        System.out.println(driver.findElement(By.className("summary_total_label")).getText());
        try {
            Thread.sleep(2000);
        }
        catch (Exception e){

        }
        driver.findElement(By.id("finish")).click();
        String Web_text=driver.findElement(By.className("complete-header")).getText();

        String text="THANK YOU FOR YOUR ORDER";
        if (Web_text.equals(text)){
            System.out.println("Passed!");
        }
        else {
            System.out.println("Failed");
        }
    }
}
