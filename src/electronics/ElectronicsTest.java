package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.Random;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/ ";
    static String menu = "Computers";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        //clicking on computer and then on desktop option
        Actions actions = new Actions(driver);
        mouseHoverToElement (By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        mouseHoverToElementAndClick (By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //2.3 Verify the "cell phones"
        String expText = "Cell phones";
        String actText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phone')]"));
        Assert.assertEquals("Not correct text", expText, actText);

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

       //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//h2/a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify the text “Nokia Lumia 1020”
        String expNText = "Nokia Lumia 1020";
        String actNText = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("Not correct text", expNText, actNText);

        //2.7 Verify the price “$349.00”
        String expectedFinalValue = "$349.00";
        String actualFinalValue = getTextFromElement(By.xpath("//span[@id='price-value-20' and text()=' $349.00 ']"));
        Assert.assertEquals("Not correct value", expectedFinalValue, actualFinalValue);

        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextTwoElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expTextMessage = "The product has been added to your shopping cart";
        String actTextMessage = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Not correct text", expTextMessage,actTextMessage);

        //2.10.1 After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.12 Verify the message "Shopping cart"
        String expNTextMessage = "Shopping cart";
        String actNTextMessage = getTextFromElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping cart message not displayed",expNTextMessage,actNTextMessage);

        //2.13 Verify the quantity is 2
        String expQuantity = "2";
        String actQuantity = getTextFromElement(By.xpath("//span[contains(text(),'(2)')]"));
        Assert.assertEquals("Verify quantity not displayed",expTextMessage,actTextMessage);

        //2.14 Verify the Total $698.00
        String expValue = "$698.00";
        String actValue = getTextFromElement(By.xpath("(//strong[text()='$698.00'])[2]"));
        Assert.assertEquals("Total value not displayed",expTextMessage,actTextMessage);

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expText2 = "Welcome, Please Sign In!";
        String actText2 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Welcome message not displayed",expText2,actText2);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        String expText5 = "Register";
        String actText5 = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Register page not displayed",expText5,actText5);

        //2.20 Fill the mandatory fields
        String firstName = "Raj";
        String lastName = "Patel";
        sendTextTwoElement(By.id("FirstName"), "Raj");
        sendTextTwoElement(By.id("LastName"), "Patel");
        Random randomGenerator = new Random();
        int counter  = randomGenerator.nextInt(9999);
        sendTextTwoElement(By.id("Email"),firstName + lastName + counter + "@email.com");
        sendTextTwoElement(By.id("Password"), "123456");
        sendTextTwoElement(By.id("ConfirmPassword"), "123456");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        String expText6 = "Your registration completed";
        String actText6 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Your registration completed not Displayed",expText6,actText6);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24 Verify the text “Shopping card”
        String expText7 = "Shopping cart";
        String actText7 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Shopping card not Displayed",expText7,actText7);

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.27 Fill the Mandatory fields
        selectByValueFromDropdown(By.id("BillingNewAddress_CountryId"), "133");
        sendTextTwoElement(By.id("BillingNewAddress_City"), "Ahmedabad");
        sendTextTwoElement(By.id("BillingNewAddress_Address1"), "999 Raghunath Ni Pol");
        sendTextTwoElement(By.id("BillingNewAddress_ZipPostalCode"), "380011");
        sendTextTwoElement(By.id("BillingNewAddress_PhoneNumber"), "9989711425");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 new-address-next-step-button' and @name='save']"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));

       // 2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

       // 2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));

        // 2.31.1 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

       // 2.32 Select “Visa” From Select credit card dropdown
       // selectByValueFromDropdown(By.id("CreditCardType"), "Visa");

        //2.33 Fill all the details
        sendTextTwoElement(By.id("CardholderName"), firstName + " " + lastName);
        sendTextTwoElement(By.id("CardNumber"), " 4318077675447723");
        selectByValueFromDropdown(By.id("ExpireMonth"), "8");
        selectByValueFromDropdown(By.id("ExpireYear"), "2029");
        sendTextTwoElement(By.id("CardCode"), "722");

        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.35 Verify “Payment Method” is “Credit Card”
        String expText8 = "Payment Method:";
        String actText8 = getTextFromElement(By.xpath("//span[contains(text(), 'Payment Method:')]"));
        Assert.assertEquals("Payment Method not Displayed",expText8,actText8);

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expText9 = "Shipping Method:";
        String actText9 = getTextFromElement(By.xpath("//span[contains(text(), 'Shipping Method:')]"));
        Assert.assertEquals("Shipping Method not Displayed",expText9,actText9);

        //2.37 Verify Total is “$698.00”
        String expValue10 = "$698.00";
        String actValue10 = getTextFromElement(By.xpath("(//strong[text()='$698.00'])[2]"));
        Assert.assertEquals("Total value not displayed",expValue10,actValue10);

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //Verify the Text “Thank You”
        String expVText = "Thank you";
        String actVText = getTextFromElement(By.xpath("//h1[text()='Thank you']"));
        Assert.assertEquals("Not correct text",expVText,actVText);

        //2.40 Verify the message “Your order has been successfully processed!”
        String expText12 = "Your order has been successfully processed!";
        String actText12 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Your order has been successfully processed! not displayed",expText12,actText12);

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        String expText13 = "Welcome to our store";
        String actText13 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Welcome to our store not Displayed",expText13,actText13);

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expUrl = "https://demo.nopcommerce.com/";
        String actUrl = driver.getCurrentUrl();
        Assert.assertEquals("Not matching URL",expUrl,actUrl);
    }
    public void closeBrowser(){
        driver.quit();
    }

}



