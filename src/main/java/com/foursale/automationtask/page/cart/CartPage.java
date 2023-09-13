package com.foursale.automationtask.page.cart;

import com.foursale.automationtask.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    //For simplicity, I will assume the cart has only one product
    private By productPriceText = By.className("inventory_item_price");
    private By checkoutButton = By.id("checkout");
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public Double getProductPrice(){
        WebElement priceWebElement = findElement(productPriceText);
        String priceText = priceWebElement.getText().replace("$", ""); // Remove the dollar sign
        return Double.parseDouble(priceText);
    }
    public void checkout(){
        findElement(checkoutButton).click();
    }
}
