package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage extends PageBase
{

    public CheckOutPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }
    @FindBy(xpath = "//a[@class='accordion-toggle' and contains(.,'Step 1: Checkout Options ')]")
    WebElement CheckOut1;

    @FindBy(xpath = "//input[@id='button-account']")
    WebElement StartButton;

    @FindBy(xpath = "//input[@placeholder = 'First Name']")
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

    @FindBy (xpath = "//select[@id='input-payment-zone']")
    WebElement zone;

    @FindBy(xpath = "//input[@name = 'agree']")
    WebElement CheckBox1;

    @FindBy(id = "button-payment-address")
    WebElement ContinueButtonPaymentAddress;

    @FindBy(xpath = "//input[@id='button-register']")
    WebElement ContinueButton1;

    @FindBy(id = "button-shipping-address")
    WebElement ContinueButton4;

    @FindBy(id = "button-shipping-method")
    WebElement ContinueButton2;

    @FindBy(xpath = "//a[contains(., 'Step 3: Delivery Details')]")
    WebElement CointinueButton3;

    @FindBy(id = "button-confirm")
    WebElement ConfirmOrder;

    @FindBy(xpath = "//input[@id = 'button-payment-method']")
            WebElement ContinueButton5;
    @FindBy(xpath = "//a[contains (@href,'common/home')]//ancestor::div[@class='pull-right']")
            WebElement OrderPlaced;

    @FindBy(xpath = "//div[@class = 'panel-collapse collapse in']")
    WebElement Panel;
    
    @FindBy(xpath = "//div[@class = 'panel-collapse collapse in']//ancestor::div[@class = 'panel-body']")
    WebElement PanelOpened;

    @FindBy(xpath = "//a[@class = 'accordion-toggle' and contains (.,'Step 3: Delivery Details ')]")
    WebElement DeliveryDetails;

    public void setPanel ()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(Panel));
    }

    //Select select = new Select(zone);
    public void ConfirmButtonClick() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(StartButton));
        clickButton(StartButton);
        //Thread.sleep(3000);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public void fillCheckoutForm(String firstName, String lastName, String email, String telephone, String password,
                                 String confirmPassword, String address, String city, String postcode,String Zone) throws InterruptedException {


        if (PanelOpened.isDisplayed()) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(FirstName));

            // Using JavaScriptExecutor to set the value of form fields
            System.out.println("Filling in the checkout form using JavaScriptExecutor...");

            setTextUsingJS(FirstName, firstName);
            setTextUsingJS(LastName, lastName);
            setTextUsingJS(Email, email);
            setTextUsingJS(Telephone, telephone);
            setTextUsingJS(Password, password);
            setTextUsingJS(ConfirmPassword, confirmPassword);
            setTextUsingJS(ContinueButtonAddress, address);
            setTextUsingJS(City, city);
            setTextUsingJS(Postcode, postcode);
            Thread.sleep(1000);
            Select select = new Select(zone);
            select.selectByValue((Zone));

            // Continue the checkout process
            clickButton(CheckBox1);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(ContinueButton1));
            clickButton(ContinueButton1);
            System.out.println("Done 1st Panel");
            System.out.println("2nd Panel");

            //2nd panel
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(ContinueButton2));
            clickButton(ContinueButton2);
            Thread.sleep(1000);
            System.out.println("Done 2nd Panel");
            System.out.println("3rd Panel");

            //3rd panel
            System.out.println("Back to Delivery Details Panel");
            try
            {
                wait.until(ExpectedConditions.elementToBeClickable(CheckBox1));
                clickButton(CheckBox1);
                clickButton(ContinueButton5);
                System.out.println("Done 4th Panel");
                System.out.println("5th Panel");
                Thread.sleep(1000);
                wait.until(ExpectedConditions.elementToBeClickable(ConfirmOrder));
                clickButton(ConfirmOrder);
                System.out.println("Done 5th Panel");


            }
            catch (Exception e)
            {
                wait.until(ExpectedConditions.elementToBeClickable(DeliveryDetails));
                clickButton(DeliveryDetails);
                wait.until(ExpectedConditions.elementToBeClickable(ContinueButton4));
                clickButton(ContinueButton4);
                System.out.println("Back to Delivery Method Panel Again");
                wait.until(ExpectedConditions.elementToBeClickable(ContinueButton2));
                clickButton(ContinueButton2);
                System.out.println("Done 3rd Panel");
                System.out.println("4th Panel");
                wait.until(ExpectedConditions.elementToBeClickable(CheckBox1));
                clickButton(CheckBox1);
                clickButton(ContinueButton5);
                System.out.println("Done 4th Panel");
                System.out.println("5th Panel");
                Thread.sleep(1000);
                wait.until(ExpectedConditions.elementToBeClickable(ConfirmOrder));
                clickButton(ConfirmOrder);
                System.out.println("Done 5th Panel");

            }


        }
    }}




