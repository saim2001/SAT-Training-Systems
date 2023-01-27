package Implementation;
import Utils.PropertyReader;
import PageObject.Login;
import org.openqa.selenium.WebDriver;

public class Implementation {

    public static void correctLogin(WebDriver driver){
        Login.usernameFeild(driver).sendKeys(PropertyReader.getConfigValue("Username"));
        Login.passwordFeild(driver).sendKeys(PropertyReader.getConfigValue("Password"));
        Login.loginBtn(driver).click();



//        WebElement required = Login.requiredAssertion(driver);
//        WebElement invalid = Login.invalidAssertions(driver);
//        if (required == null && invalid == null){
//            return "login success";
//        }
//        else if (required != null) {
//            return "username or password not entered";
//        }
//        else if (invalid != null) {
//            return "username or password in correct";
//        }
//        {
//            return "Username password not filled";
//        }
    }

    public  static void invalidLogin(WebDriver driver){
        Login.usernameFeild(driver).sendKeys(PropertyReader.getConfigValue("Username_invalid"));
        Login.passwordFeild(driver).sendKeys(PropertyReader.getConfigValue("Password_invalid"));
        Login.loginBtn(driver).click();
    }


    public  static void missingUsernameLogin(WebDriver driver){
        Login.passwordFeild(driver).sendKeys(PropertyReader.getConfigValue("Password"));
        Login.loginBtn(driver).click();
    }

    public  static void missingPasswordLogin(WebDriver driver){
        Login.usernameFeild(driver).sendKeys(PropertyReader.getConfigValue("Username"));
        Login.loginBtn(driver).click();
    }

    public  static void missingLogin(WebDriver driver){
        Login.loginBtn(driver).click();
    }



}
