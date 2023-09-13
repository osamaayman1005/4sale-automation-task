package com.foursale.automationtask.page.checkout;

import com.foursale.automationtask.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage {

    private By completeMessage = By.className("complete-header");

    public CompletePage(WebDriver driver) {
        super(driver);
    }
    public String getCompleteMessage(){
        return findElement(completeMessage).getText();
    }
}
