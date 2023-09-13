## Swag Labs's E-commerce Website Test Automation for 4sale Automation Task

This project includes automated tests for an e-commerce website using WebDriver and TestNG. 

---

### Prerequisites:

Before running the tests, ensure that you have the following prerequisites installed on your system:

*   Java Development Kit (JDK) 
*   Maven 
*   Chrome Browser

### Installation

1.  Clone this repository to your local machine:
2.  Navigate to the project directory
3.  Build the project using Maven to download dependencies and compile the code:

```plaintext
mvn clean install
```

---

### Running the Tests

To execute the automated test, just run the _checkout-testing-suite.xml file._

---

### Project Structure

The project has only one test class with one test case:

*   src/test/java/com/foursale/automationtask/CheckOutTests.java

The project has many POM objects extending from src/main/java/com/foursale/automationtask/page/BasePage.java:

*   src/main/java/com/foursale/automationtask/page/login/LoginPage.java
*   src/main/java/com/foursale/automationtask/page/products/ProductsPage.java
*   src/main/java/com/foursale/automationtask/page/cart/CartPage.java
*   src/main/java/com/foursale/automationtask/page/checkout/CustomerInformationPage.java
*   src/main/java/com/foursale/automationtask/page/checkout/OverviewPage.java
*   src/main/java/com/foursale/automationtask/page/checkout/CompletePage.java

The project has an enum for all sorting methods for products.

*   src/main/java/com/foursale/automationtask/enums/ProductSortingOption.java

### How the code works

1.  All the credentials, website url and any input data are added to the test case as parameters.
2.  The BeforeMethod function runs to initialize the WebDriver using WebDriverManager and ChromeDriver, then navigates to the website and logins using the standard user.
3.  The testCheckOutLowestPriceItem Method runs with the following logic: 
    1.  Sort the product list by price (low to high)
    2.  Select the first item from the list
    3.  Go to the cart
    4.  Verify that the item in the cart is the same item selected (For simplicity, I just asserted the price)
    5.  Proceed to checkout
    6.  Add customer information
    7.  Go to checkout overview
    8.  Verify that the item in the overview is the same item selected (For simplicity, I just asserted the price)
    9.  Complete the checkout
    10.  Verify that the shown message is the success message
4.  The AfterMethod runs and stops the driver.
5.  the AfterSuite runs to open the report

### Reporting

After the test case is executed, a basic report is shown in the user's browser showing the status of the test case.

---

#### Kindly note that this project is not a real world project and it is over-engineered for the purpose of the task.
