import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Session_4_Assignment {
    private static WebDriver driver;

    public static void main(String[] args){
        Initiate_driver("C:\\Users\\saim rao\\Desktop\\SAT training System.ltd\\Java_Testing\\google_chrome\\chromedriver.exe");
        Auto_navigate("https://ultimateqa.com/automation");
        Auto_login("saimrao49@gmail.com","saim1235678");
        Auto_register("Saim","rao","saimrao893@gmail.com","saim12345678");
        Auto_logout();
        Auto_login("saimrao893@gmail.com","saim12345678");

    }

    static void Initiate_driver(String Driver_path){
        System.setProperty("webdriver.chrome.driver", Driver_path);
        driver=new ChromeDriver();
    }

    static void Auto_navigate(String Web_URL){
        driver.navigate().to(Web_URL);
        driver.findElement(By.linkText("Login automation")).click();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
    }
    static void Auto_login(String Email, String Password){

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
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        System.out.println(driver.getTitle());

        driver.findElement(By.cssSelector("button[class=\"button button-primary g-recaptcha\"]")).click();
        if ((driver.getTitle()).equals("Sign In - Ultimate QA")){
            System.out.println("Email or password incorrect!");
            driver.findElement(By.xpath("//div[@data-type=\"alert\"]")).click();
        }
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[contains(text(),\"Create a new account\")]")).click();




    }
    static void Auto_register(String First_name,String Last_name,String Email, String Password){
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);


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
    static void Auto_logout(){
        driver.findElement(By.cssSelector("button[class=\"dropdown__toggle-button\"]")).click();
        driver.findElement(By.xpath("(//ul[@id=\"header-dropdown-menu\"]/li)[4]/a")).click();
        driver.findElement(By.xpath("//li[@class=\"header__nav-item header__nav-sign-in\"]/a")).click();
    }
}
