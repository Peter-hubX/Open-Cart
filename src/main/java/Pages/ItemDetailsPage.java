package Pages;

import Tests.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class ItemDetailsPage extends PageBase
{
    public ItemDetailsPage(WebDriver driver) throws AWTException {
        super(TestBase.getDriver());
    }

    @FindBy(xpath = "//input[@name = 'option[218]' and contains(@value , '5')]")
    WebElement RadioButton;

    @FindBy(xpath = "//input[@name = 'option[223][]' and contains(@value , '9')]")
    WebElement CheckBox;

    @FindBy(id = "input-option217")
    WebElement DropDownButton;

    @FindBy(xpath = "//textarea[@id='input-option209']")
    WebElement TextArea;

    @FindBy(id = "button-upload222")
    WebElement FileUpload;
////i[@class='fa fa-calendar']/ancestor::span[@class='input-group-btn']/button[1]
    ////i[@class='fa fa-calendar' and contains (@name,option[219])][1]
    @FindBy(xpath = "//i[@class='fa fa-calendar']/ancestor::span[@class='input-group-btn']/button[1]")
    WebElement FirstDate;

    @FindBy(xpath = "//i[@class='fa fa-calendar' and contains (@name,option[219])][2]")
    WebElement SecondDate;

    @FindBy(xpath = "//i[@class='fa fa-calendar' and contains (@name,option[219])][3]")
    WebElement ThirdDate;

    @FindBy(id = "button-cart")
    WebElement AddToCart;

    @FindBy(xpath = "//button[@class = 'btn btn-inverse btn-block btn-lg dropdown-toggle']")
            WebElement CartButton;

    @FindBy(xpath = "//a[contains(@href, 'checkout/cart') and contains(., 'View Cart')]")
            WebElement ViewCartButton;
    @FindBy(xpath = "//a[contains (@href,'ui') and contains(@class,'btn btn-primary')]")
            WebElement CheckoutButton;

    Robot robot = new Robot();
    Select select = new Select(DropDownButton);

    public void FillData ()
    {
        clickButton(RadioButton);
        clickButton(CheckBox);
        select.selectByValue("4");
        sendText(TextArea, "Hello From Future");
        TextArea.sendKeys(Keys.TAB);
    }
    public void UploadFile() throws InterruptedException {
        clickButton(FileUpload);
        String FilePath = "C:\\Users\\peter\\why-just-why.gif";
        StringSelection str = new StringSelection(FilePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        /*if (driver == null) {
            System.out.println("WebDriver is not initialized!");
            return;}*/
    }
    public void alert() throws InterruptedException {
        try {
            //Thread.sleep(2000);
            // Wait for the alert to appear
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            //wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);
            alert.dismiss();
            System.out.println("Alert accepted successfully.");
        } catch (TimeoutException e) {
            Thread.sleep(3000);
            System.out.println("No alert appeared within the specified time.");
        } catch (UnhandledAlertException e) {
            Thread.sleep(3000);
            System.out.println("Alert was not handled properly, trying to accept it...");
            Alert alert = driver.switchTo().alert();  // Switch to the alert again
            alert.accept();
        //Thread.sleep(3000);
    }}
    public void FindDate() throws InterruptedException {
        //Thread.sleep(2000);
        clickButton(FirstDate);
        String CurrentDate = driver.findElement(By.xpath("//th[@class='picker-switch' and contains(text(),'February 2011')][1]")).getText();
        System.out.println("Current date: " + CurrentDate);
        // Verify that the current date is February 2022. If not, click the 'Next' button and repeat until February 2022.
        if (CurrentDate.trim().isEmpty()) {
            System.out.println("Error: CurrentDate is empty or not found.");
            return;  // Early exit if date is invalid
        }
        String[] DateParts = CurrentDate.split(" ");
        if (DateParts.length < 2) {
            System.out.println("Error: DateParts array length is " + DateParts.length);
            System.out.println("1_CurrentDate content: '" + CurrentDate + "'");

            return;
        }

        String Month = DateParts[0].trim();
        String Year = DateParts[1].trim();
        System.out.println("Month: " + Month + ", Year: " + Year);
        while (!(Month.equals("February") && Year.equals("2022")))
        {
            driver.findElement(By.xpath("//th[@class='next'][1]")).click();
            System.out.println("2_CurrentDate content: '" + CurrentDate + "'");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement dateHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'bootstrap-datetimepicker-widget') and contains(@style, 'display: block')]//th[@class='picker-switch' and text()='February 2011']")));
            //String CurrentDate_2 = driver.findElement(By.xpath("//div[contains(@class, 'bootstrap-datetimepicker-widget') and contains(@style, 'display: block')]//th[@class='picker-switch' and text()='February 2011']")).getText();
            String CurrentDate_2 = dateHeader.getText();
            System.out.println("3_CurrentDate content: '" + CurrentDate_2 + "'");
            DateParts = CurrentDate_2.split(" ");
            Month = DateParts[0].trim();
            Year = DateParts[1].trim();
        }
        driver.findElement(By.xpath("//td[@class='day' and contains(text(),'25')][1]")).click();
    }
    public void Submit() throws InterruptedException {
        Thread.sleep(2000);
        clickButton(AddToCart);
    }
    public void ViewCart() throws InterruptedException {
        Thread.sleep(2000);
        clickButton(CartButton);
        clickButton(ViewCartButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(CheckoutButton));
        clickButton(CheckoutButton);
    }




}
