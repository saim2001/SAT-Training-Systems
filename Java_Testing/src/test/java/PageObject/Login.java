package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    public static WebElement usernameFeild(WebDriver driver){
        WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        return username;
    }

    public static WebElement passwordFeild(WebDriver driver){
        WebElement password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
        return password;
    }

    public static WebElement loginBtn(WebDriver driver){
        WebElement Btn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        return Btn;
    }

    public static WebElement requiredAssertion(WebDriver driver){
        WebElement required = driver.findElement(By.cssSelector("span[class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]"));
        return required;
    }

    public static WebElement invalidAssertions(WebDriver driver){
        WebElement invalid = driver.findElement(By.cssSelector("p[class=\"oxd-text oxd-text--p oxd-alert-content-text\"]"));
        return invalid;
    }


}
