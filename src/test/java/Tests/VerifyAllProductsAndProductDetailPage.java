package Tests;

import Pages.ProductDetails;
import Pages.ProductsPage;
import com.aventstack.extentreports.Status;
import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;

public class VerifyAllProductsAndProductDetailPage extends Setup {
    @Test
    public void VerifyAllProductsAndProductDetailVisibility(){
        test = extent.createTest("Test Navigation To Product Details Page");
        test.info("test case started");
        try {
            Assert.assertTrue(homePage.HomePageVisibility());
            test.log(Status.PASS, "Home Page is visible");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Home Page is Not Visible");
        }
        ProductsPage productsPage = homePage.ClickProductsBTN();
        try {
            Assert.assertEquals(productsPage.UserIsNavigatedToProductsPageSuccessfully(), "ALL PRODUCTS");
            test.log(Status.PASS, "User Navigated To Product Page");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Navigation To Product Page is Field");
        }
        try {
            Assert.assertEquals(productsPage.TheProductsListIsVisible(), 34);
            test.log(Status.PASS, "Product List is Visible");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Product List is Not Visible");
        }
        ProductDetails productdetails = productsPage.ClickViewProduct();
        try {
            Assert.assertEquals(productdetails.UserNavigatedToProductDetailsPage(), "Blue Top");
            test.log(Status.PASS, "User Navigated To Product Details Page");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Navigation To Product Details Page is Field");
        }
        try {
            Assert.assertEquals(productdetails.ProductCategoryIsVisible(), "Category: Women > Tops");
            test.log(Status.PASS, "Product Category is Visible");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Product Category is Not Visible");
        }
        try {
            Assert.assertEquals(productdetails.ProductPriceIsVisible(), "Rs. 500");
            test.log(Status.PASS, "Product Price is Visible");
        } catch (Exception e) {
            test.log(Status.FAIL, "Product Price is Not Visible");
        }
        try {
            Assert.assertEquals(productdetails.ProductAvailabilityIsVisible(), "Availability: In Stock");
            test.log(Status.PASS, "Product Availability is Visible");
        } catch (Exception e) {
            test.log(Status.FAIL, "Product Availability is Not Visible");
        }
        try {
            Assert.assertEquals(productdetails.ProductConditionIsVisible(), "Condition: New");
            test.log(Status.PASS, "Product Condition Is Visible");
        } catch (Exception e) {
            test.log(Status.FAIL, "Product Condition is Not Visible");
        }
        try {
            Assert.assertEquals(productdetails.ProductBrandIsVisible(), "Brand: Polo");
            test.log(Status.PASS, "Product Brand is Visible");
        } catch (Exception e) {
            test.log(Status.FAIL, "Product Brand is Not Visible");
        }

    }
}
