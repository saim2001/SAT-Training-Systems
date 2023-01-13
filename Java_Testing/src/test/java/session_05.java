import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class session_05 {
    WebDriver driver;

    public  WebDriver launchWebBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://ultimateqa.com/automation");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Login automation")).click();
        return driver;
    }

    @Test(priority = 2,dataProvider = "Login_data")
    public  void Login(String Email, String Password){
        driver.findElement(By.id("user[email]")).sendKeys(Email);
        driver.findElement(By.id("user[password]")).sendKeys(Password);

        String Class_name_eml=driver.findElement(By.xpath("//*[contains(text(),\"Please enter a valid email address\")]")).getAttribute("class");
        String Class_Exp_eml="form__error-msg hidden";
        String Class_name_pwd=driver.findElement(By.xpath("//*[contains(text(),\" This field cannot be blank\")]")).getAttribute("class");
        String Class_Exp_pwd="form__error-msg hidden";


        if (Class_name_eml.equals(Class_Exp_eml) && Class_name_pwd.equals(Class_Exp_pwd)){
            System.out.println("Email address correct and password is inserted ready to login !");
        }
        else {
            System.out.println("Email address incorrect or password left blank cannot login !");

        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());

        driver.findElement(By.cssSelector("button[class=\"button button-primary g-recaptcha\"]")).click();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

    }
    @Test(priority = 0,dataProvider = "Registration_data")
    public void Registration(String First_name,String Last_name,String Email, String Password){
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[contains(text(),\"Create a new account\")]")).click();
        driver.findElement(By.xpath("(//form[@action=\"/users\"]//child::div//child::input)[1]")).sendKeys(First_name);
        driver.findElement(By.xpath("(//form[@action=\"/users\"]//child::div//child::input)[2]")).sendKeys(Last_name);
        driver.findElement(By.xpath("(//form[@action=\"/users\"]//child::div//child::input)[3]")).sendKeys(Email);
        driver.findElement(By.xpath("(//form[@action=\"/users\"]//child::div//child::input)[4]")).sendKeys(Password);
        driver.findElement(By.xpath("(//form[@action=\"/users\"]//child::div//child::input)[6]")).click();
        driver.findElement(By.xpath("//div[@class=\"form__button-group\"]/button")).click();
        if ((driver.getTitle()).equals("Create a new account - Ultimate QA")) {
            int count = driver.findElements(By.xpath("//li[@class=\"form-error__list-item\"]")).size();
            for (int i = 0; i < count; i++) {
                System.out.println(driver.findElements(By.xpath("//li[@class=\"form-error__list-item\"]")).get(i).getText());
            }
        }
    }
    @Test(priority = 1)
    public void Auto_logout(){
        driver.findElement(By.cssSelector("button[class=\"dropdown__toggle-button\"]")).click();
        driver.findElement(By.xpath("(//ul[@id=\"header-dropdown-menu\"]/li)[4]/a")).click();
        driver.findElement(By.xpath("//li[@class=\"header__nav-item header__nav-sign-in\"]/a")).click();
    }
    @AfterClass
    public void Exit(){
        driver.quit();
    }
    @DataProvider(name = "Registration_data")
    public Object[][] Registeration_data(){

        return new Object[][]{
                {"Saim","rao","saimrao10@gmail.com","saim12345678"}
        };
    }
    @DataProvider(name = "Login_data")
    public Object[][] Login_data(){

        return new Object[][]{
                {"saimrao10@gmail.com","saim12345678"}
        };
    }
}
