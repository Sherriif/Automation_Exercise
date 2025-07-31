package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By AllProductsText = By.cssSelector("h2[class='title text-center']");
    By ProductsList = By.cssSelector("img[alt='ecommerce website products']");
    By ClickViewProduct = By.cssSelector("a[href='/product_details/1']");


    public String UserIsNavigatedToProductsPageSuccessfully(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(AllProductsText));
        return  element.getText();
    }
    public int TheProductsListIsVisible(){
        List<WebElement> Products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ProductsList));
        return Products.size();
    }
    public ProductDetails ClickViewProduct(){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        driver.findElement(ClickViewProduct);
        js.executeScript("window.scrollBy(0,600)","");
        driver.findElement(ClickViewProduct).click();
        return new ProductDetails(driver);
    }
}

