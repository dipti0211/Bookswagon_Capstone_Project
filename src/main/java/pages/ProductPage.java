package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchBox = By.id("inputbar"); // Replace with actual locator
    private By searchButton = By.id("searchButton"); // Replace with actual locator
    private By firstProduct = By.cssSelector(".search-result .product:first-child"); // Replace with actual locator
    private By addToCartButton = By.id("addToCartButton"); // Replace with actual locator

    public void searchProduct(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void selectFirstProduct() {
        driver.findElement(firstProduct).click();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public boolean isProductDetailsDisplayed() {
        return driver.findElement(firstProduct).isDisplayed();
    }
}
