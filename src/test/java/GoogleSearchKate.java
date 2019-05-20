import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchKate {
    static WebDriver driver;

    @Test
    public static void test001() {
        System.setProperty("webdriver.gecko.driver", "/Users/greatkate/IdeaProjects/TestNG/src/test/recources/driver/geckodriver");
        driver = new FirefoxDriver();
        openMainPage();
        typeQuery();
        submitSearch();
        assertResultPage();


    }

    public static void assertResultPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("resultStats")));
        WebElement assertion = driver.findElement(By.id("resultStats"));
        boolean isElementsDisplayed = assertion.isDisplayed();
        boolean expected = true;
        Assert.assertEquals(isElementsDisplayed, expected);
        driver.close();
    }

    public static void submitSearch() {
        WebElement searchInput = driver.findElement(By.cssSelector(".gLFyf"));
        searchInput.submit();
    }

    public static void typeQuery() {
        WebElement searchInput = driver.findElement(By.cssSelector(".gLFyf"));
        searchInput.sendKeys("portnov computer school");

    }

    public static void openMainPage() {
        String url = "https://www.google.com";
        driver.get(url);
    }


}
