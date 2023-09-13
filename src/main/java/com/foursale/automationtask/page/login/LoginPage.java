package com.foursale.automationtask.page.login;
import com.foursale.automationtask.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends BasePage {

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void login(String username, String password){
        findElement(usernameField).sendKeys(username);
        findElement(passwordField).sendKeys(password);
        findElement(loginButton).click();
    }
}
