import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchKate {
    static WebDriver driver;
    //static String key = "Sales usa Cars";

    @Test(dataProvider = "test1")
    public static void test001(String key) {
        System.setProperty("webdriver.gecko.driver", "/Users/greatkate/IdeaProjects/TestNG/src/test/recources/driver/geckodriver");
        driver = new FirefoxDriver();


        openMainPage();
        typeQuery(key);
        submitSearch();
        wailForResults();
        assertResultPage();



    }

    public static void assertResultPage() {
        WebElement assertion = driver.findElement(By.id("resultStats"));
        boolean isElementsDisplayed = assertion.isDisplayed();
        boolean expected = true;
        Assert.assertEquals(isElementsDisplayed, expected);
        driver.close();
    }

    public static void wailForResults() {
        By resultStatesElement = By.id("resultStats");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultStatesElement));
    }

    @DataProvider(name = "test1")
    public Object[][] createData() {

        return new Object[][]{
                {"Portnov computer school"},
                {"Sey hi new employee"},
                {"1234567890"}
        };

    }

    public static void submitSearch() {
        WebElement searchInput = driver.findElement(By.cssSelector(".gLFyf"));
        searchInput.submit();
    }

    public static void typeQuery(String key) {
        WebElement searchInput = driver.findElement(By.cssSelector(".gLFyf"));
        searchInput.sendKeys(key);

    }

    public static void openMainPage() {
        String url = "https://www.google.com";
        driver.get(url);
    }


}
