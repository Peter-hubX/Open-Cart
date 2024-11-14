package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends PageBase
{
    protected Actions actions;
    public HomePage(WebDriver driver)
    {
        super(driver);
        this.actions = new Actions(driver);
    }

    @FindBy(xpath = "//a[@class='dropdown-toggle' and contains (text(),'Components')]")
    WebElement Components;

    @FindBy(xpath = "//li[@class='dropdown' and .//a[contains(text(), 'Components')]]//ul[@class='list-unstyled']/li/a")
    List <WebElement> DropDowns;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchInput;

    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement searchButton;

    @FindBy(xpath= "//img[@title='Apple Cinema 30\"']//ancestor::div[@class='image']")
    WebElement Image;

    public void search(String DropDownWord)
    {
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        actions.moveToElement( Components).perform();
        for(WebElement option: DropDowns)
        {
            if(option.getText().equals(DropDownWord))
            {
                option.click();
                break;
            }
        }
        Image.click();
    }
}


        /*searchInput.click();
        searchInput.sendKeys(SearchWord);
        searchButton.click();*/

