import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;


public class WindowHandlestest {
    WebDriver driver;

    By linkPath = By.xpath("/html/body/div[2]/div/div/a");
    //By textNewPage = By.cssSelector(".example > h3:nth-child(1)");

    String window1;
    String window2;


    Set<String> allWindowHandles;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "/Users/greatkate/IdeaProjects/TestNG/src/test/recources/driver/geckodriver");
        driver = new FirefoxDriver();
    }


    @Test
    public void test0001() throws InterruptedException {


        openMainPage();
        clickOnTheLink(linkPath);
        getWindowHandles();
        goToWindow(window2);
        assertPageByText("New Window");
        goToWindow(window1);
        assertPageByTitle("Internet");
        goToWindow(window2);
        assertPageByTitle("New Window");
        goToWindow(window1);
        assertPageByText("Opening a new window");


    }

    private void goToWindow(String window) {
        driver.switchTo().window(window);
    }


    public void assertPageByTitle(String title) {
        String pageTitle = driver.getTitle();
        boolean isPresented = pageTitle.contains(title);
        Assert.assertTrue(isPresented);
    }


    public void assertPageByText(String text) {
        String pageSource = driver.getPageSource();
        boolean isPresented = pageSource.contains(text);
        Assert.assertTrue(isPresented);

    }

    private void waitFor(int sec, By element) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

        // wait.withTimeout(sec,TimeUnit.SECONDS);

    }


    public void getWindowHandles() {
        allWindowHandles = driver.getWindowHandles();

        window1 = (String) allWindowHandles.toArray()[0];
        window2 = (String) allWindowHandles.toArray()[1];
    }

    public void clickOnTheLink(By path) throws InterruptedException {
        WebElement element = driver.findElement(path);
        element.click();
        Thread.sleep(1000);
    }

    public void openMainPage() {
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();

    }

    @AfterSuite

    public void afterSuite() {
        driver.close();
    }
}
