package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
    public static WebDriver driver;
    public static WebDriver getDriver()
    {
        return driver;
    }
    @BeforeSuite
    public void BeforeTesting()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
    }
}
