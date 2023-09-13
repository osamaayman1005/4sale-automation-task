package com.foursale.automationtask;

import com.foursale.automationtask.enums.ProductSortingOption;
import com.foursale.automationtask.page.cart.CartPage;
import com.foursale.automationtask.page.checkout.CompletePage;
import com.foursale.automationtask.page.checkout.CustomerInformationPage;
import com.foursale.automationtask.page.checkout.OverviewPage;
import com.foursale.automationtask.page.login.LoginPage;
import com.foursale.automationtask.page.products.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.time.Duration;

public class CheckOutTests {

    private WebDriver driver;

    @Test(description = "Verify that the user can checkout the cheapest product")
    @Parameters({"firstName", "lastName", "postalCode"})
    public void testCheckOutLowestPriceItem(String firstName, String lastName, String postalCode){
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortProducts(ProductSortingOption.PRICE_LOW_TO_HIGH);
        productsPage.addProductToCartByIndex(0);
        Double productPriceInList = productsPage.getProductPrice(0);
        productsPage.goToShoppingCart();

        CartPage cartPage = new CartPage(driver);
        Double productPriceInCart = cartPage.getProductPrice();
        //for simplicity, I will only check for the price of the item to make sure it is added correctly
        Assert.assertEquals(productPriceInCart, productPriceInList,
                "verify that price of the product in the cart equals" +
                        " to the price of the product in the product list");
        CustomerInformationPage customerInformationPage = new CustomerInformationPage(driver);
        cartPage.checkout();

        customerInformationPage.addCustomerInformation(firstName, lastName, postalCode);

        OverviewPage overviewPage = new OverviewPage(driver);
        Double productPriceInOverview = overviewPage.getProductPrice();
        Assert.assertEquals(productPriceInOverview, productPriceInList,
                "verify that price of the product in the checkout overview equals" +
                        " to the price of the product in the product list");
        overviewPage.finish();

        CompletePage completePage = new CompletePage(driver);
        String completeMessage = completePage.getCompleteMessage();
        Assert.assertEquals(completeMessage, "Thank you for your order!",
                "Verify that the the order is created successfully");
    }
    @BeforeMethod
    @Parameters({"url", "username", "password"})
    public void setUp(String url, String username, String password) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    //This should be added in a separate config file, i tried but failed when i added it as a listener
    @AfterSuite
    public void openTestNGReport() {
        try {
            String reportFilePath = "F:\\Projects\\4sale-automation-task\\test-output\\old\\index.html"; // Update with your actual file path

            File reportFile = new File(reportFilePath);

            if (reportFile.exists() && reportFile.isFile() && reportFilePath.endsWith(".html")) {
                Desktop.getDesktop().browse(reportFile.toURI());
            } else {
                System.out.println("TestNG HTML report file not found or is not valid.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
