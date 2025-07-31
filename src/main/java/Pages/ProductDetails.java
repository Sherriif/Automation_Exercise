package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetails {
    WebDriver driver;
    WebDriverWait wait;

    public ProductDetails(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By ProductName = By.cssSelector("div[class='product-information'] h2");
    By ProductCategory = By.xpath("//p[normalize-space()='Category: Women > Tops']");
    By ProductPrice = By.cssSelector("div[class='product-information'] span span");
    By ProductAvailability = By.xpath("//div[@class='product-details']//p[2]");
    By ProductCondition = By.xpath("//body//section//p[3]");
    By ProductBrand = By.xpath("//body//section//p[4]");

    public String UserNavigatedToProductDetailsPage(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductName));
        return element.getText();
    }

    public String ProductCategoryIsVisible(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductCategory));
        return element.getText();
    }

    public String ProductPriceIsVisible(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPrice));
        return element.getText();
    }

    public String ProductAvailabilityIsVisible(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductAvailability));
        return element.getText();
    }

    public String ProductConditionIsVisible(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductCondition));
        return element.getText();
    }

    public String ProductBrandIsVisible(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductBrand));
        return element.getText();
    }


}
