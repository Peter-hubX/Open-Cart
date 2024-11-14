package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase
{
    protected WebDriver driver;
    public PageBase(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Method to click a button
    public void clickButton(WebElement element)
    {
        element.click();
    }

    // Method to send a text to a field
    public void sendText(WebElement element, String text)
    {
        element.clear();  // Clear any existing text in the field
        element.sendKeys(text);
    }

    public void Verify(WebElement element)
    {
        if (!element.isDisplayed())
            throw new IllegalStateException("Element is not displayed");
        System.out.println("Element is displayed");
    }
    // Method to verify if a certain text is present in a page
}
