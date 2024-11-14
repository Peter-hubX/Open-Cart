package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage extends PageBase
{

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    @FindBy(xpath = "//a[@class='accordion-toggle' and contains(.,'Step 1: Checkout Options ')]")
    WebElement CheckOut1;
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement ContinueButton1;

    @FindBy(id = "input-payment-firstname")
    WebElement FirstName;

    @FindBy(id = "input-payment-lastname")
    WebElement LastName;

    @FindBy(id = "input-payment-email")
    WebElement Email;

    @FindBy(id = "input-payment-telephone")
    WebElement Telephone;

    @FindBy(id = "input-payment-password")
    WebElement Password;

    @FindBy(id = "input-payment-confirm")
    WebElement ConfirmPassword;

    @FindBy(id = "input-payment-address-1")
    WebElement ContinueButtonAddress;

    @FindBy(id = "input-payment-city")
    WebElement City;

    @FindBy(id = "input-payment-postcode")
    WebElement Postcode;

    @FindBy(id = "input-payment-zone")
    WebElement zone;

    @FindBy(xpath = "//input[@name = 'agree']")
    WebElement CheckBox1;

    @FindBy(id = "button-payment-address")
    WebElement ContinueButtonPaymentAddress;

    @FindBy(id = "button-register")
    WebElement ContinueButton2;

    @FindBy(id = "button-shipping-address")
    WebElement ContinueButton4;

    @FindBy(id = "button-shipping-method")
    WebElement ContinueButton3;

    @FindBy(xpath = "//a[contains(., 'Step 3: Delivery Details')]")
    WebElement Step3;

    @FindBy(id = "button-confirm")
    WebElement ConfirmOrder;

    @FindBy(xpath = "button-payment-method")
            WebElement ContinueButton5;
    @FindBy(xpath = "//a[contains (@href,'common/home')]//ancestor::div[@class='pull-right']")
            WebElement OrderPlaced;

    Select select = new Select(zone);

    public void fillCheckoutForm(String firstName, String lastName, String email, String telephone, String password, String confirmPassword,
                                String address, String city, String postcode, String country) throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOf(CheckOut1));
        clickButton(CheckOut1);
        wait.until(ExpectedConditions.visibilityOf(ContinueButton1));
        Thread.sleep(4000);
        clickButton(ContinueButton1);
        sendText(FirstName, firstName);
        sendText(LastName, lastName);
        sendText(Email, email);
        sendText(Telephone, telephone);
        sendText(Password, password);
        sendText(ConfirmPassword, confirmPassword);
        sendText(ContinueButtonAddress, address);
        sendText(City, city);
        sendText(Postcode, postcode);
        select.selectByVisibleText(country);
        clickButton(CheckBox1);
        clickButton(ContinueButton1);
        wait.until(ExpectedConditions.visibilityOf(ContinueButton2));
        clickButton(ContinueButton2);
        Thread.sleep(2);
        clickButton(Step3);
        Thread.sleep(2);
        clickButton(ContinueButton4);
        Thread.sleep(2);
        clickButton(ContinueButton3);
        Thread.sleep(2);
        clickButton(ContinueButton5);
        Thread.sleep(2);
        clickButton(CheckBox1);
        clickButton(ConfirmOrder);
        wait.until(ExpectedConditions.visibilityOf(OrderPlaced));
        clickButton(OrderPlaced);
    }
}
