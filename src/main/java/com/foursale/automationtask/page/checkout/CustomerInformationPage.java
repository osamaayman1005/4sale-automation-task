package com.foursale.automationtask.page.checkout;

import com.foursale.automationtask.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerInformationPage extends BasePage {

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");

    public CustomerInformationPage(WebDriver driver) {
        super(driver);
    }
    public void addCustomerInformation(String firstName, String lastName, String postalCode){
        findElement(firstNameField).sendKeys(firstName);
        findElement(lastNameField).sendKeys(lastName);
        findElement(postalCodeField).sendKeys(postalCode);
        findElement(continueButton).click();
    }
}
