package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCasesPage {
    WebDriver driver;
    WebDriverWait wait;

    public TestCasesPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By TestCasesPageIsVisible = By.cssSelector("h2[class='title text-center'] b");

    public String SuccessfulNavigationForTestCasesPage(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(TestCasesPageIsVisible));
        return element.getText();
    }
}
