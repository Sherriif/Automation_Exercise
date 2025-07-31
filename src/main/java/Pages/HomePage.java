package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    //CONSTRUCTOR
    public HomePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By FeaturedItems = By.cssSelector("div[class='features_items'] h2[class='title text-center']");
    By Login_SignupBTN = By.cssSelector("a[href='/login']");
    By TestCaseBtn = By.xpath("//a[contains(text(),'Test Cases')]");
    By ProductBTN = By.cssSelector("a[href='/products']");

    public boolean HomePageVisibility(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(FeaturedItems));
        return element.isDisplayed();

    }
    //click on login/signup button
    public Login_SignupPage clickOnLogin(){
        driver.findElement(Login_SignupBTN).click();
        return new Login_SignupPage(driver);
    }
    public TestCasesPage ClickOnTestCasesBtn(){
        driver.findElement(TestCaseBtn).click();
        return new TestCasesPage(driver);
    }
    public ProductsPage ClickProductsBTN(){
        driver.findElement(ProductBTN).click();
        return new ProductsPage(driver);

    }
}
