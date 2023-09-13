package com.foursale.automationtask.page.products;

import com.foursale.automationtask.enums.ProductSortingOption;
import com.foursale.automationtask.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {

    private By productsSortDropDown = By.className("product_sort_container");
    private By productCards = By.className("inventory_item");
    private By productAddToCartButton = By.tagName("button");
    private By productPriceText = By.className("inventory_item_price");
    private By cartButton = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public void sortProducts(ProductSortingOption productSortingOption){
        Select productsSortSelector = new Select(findElement(productsSortDropDown));
        productsSortSelector.selectByValue(productSortingOption.getValue());
    }
    public void addProductToCartByIndex(int index){
        List<WebElement> products = findElements(productCards);
        products.get(index).findElement(productAddToCartButton).click();
    }
    public Double getProductPrice(int index){
        List<WebElement> products = findElements(productCards);
        WebElement priceWebElement = products.get(index).findElement(productPriceText);
        String priceText = priceWebElement.getText().replace("$", ""); // Remove the dollar sign
        return Double.parseDouble(priceText);
    }
    public void goToShoppingCart(){
        findElement(cartButton).click();
    }
}