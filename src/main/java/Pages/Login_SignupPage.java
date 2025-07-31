package Pages;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login_SignupPage {
    WebDriver driver;
    WebDriverWait wait ;

    //Constructor
    public Login_SignupPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Locators
    By NewUserSignupText = By.cssSelector("div[class='signup-form'] h2");
    By Name = By.xpath("//*[@placeholder='Name']");
    By EmailAddress = By.cssSelector("input[data-qa='signup-email']");
    By ClickSignup = By.cssSelector("button[data-qa='signup-button']");
    By SignupErrorMessage = By.cssSelector("p[style='color: red;']");
    By ClickHomeBtn = By.cssSelector("li:nth-child(1) a:nth-child(1)");

    //Methods
    public String NewUserSignupVisibility(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(NewUserSignupText));
        return element.getText();
    }
    public void SetName(String username){
        driver.findElement(Name).sendKeys(username);
    }
    public void SetEmailAddress(String Email){
        driver.findElement(EmailAddress).sendKeys(Email);
    }
    public void ClickSignup(){
        driver.findElement(ClickSignup).click();
    }
    public String VerifyErrorMessageIsVisible(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(SignupErrorMessage));
        return element.getText();
    }
    public HomePage ClickHome(){
        driver.findElement(ClickHomeBtn).click();
        return new HomePage(driver);
    }

}
