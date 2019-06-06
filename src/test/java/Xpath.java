import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Xpath {
    WebDriver driver;
    String absoluteXpath = "/html/body/div/div/form/div/div[1]/div/input";
    String relativeXpath = "//form/div/div[1]/div/input";
    String singleAttribute = "//input[@name='restaurant_id']";
    String multipleAttributes = "//*[@class='MuiInput-input-118'][@name='restaurant_id']";
    String usingAnd = "//*[@class='MuiInput-input-118'and @type='text']";
    String usingOr = "//*[@name='restaurant_id'or@type='text']";
    String usingContains = "//input[contains(@name,'taurant_id')]";
    String usingStartsWith = "//*[starts-with(@name,'rest')]";
    String usingText = "//*[text()='Log In']";
    String usingLast = "(//input[@type='text'])[last()-1]";
    String usingPosition = "(//input[@type = 'text'])[position()=1]";
    String usingIndex = "(//input[@type ='text'])[1]";
    String usingFollowing = "//div[@id='main']//following::input[@name='restaurant_id']";
    String usingPreceding = "//div[@id='main']//following::input[@name='restaurant_id']";

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.gecko.driver", "/Users/greatkate/IdeaProjects/TestNG/src/test/recources/driver/geckodriver");
        driver = new FirefoxDriver();
    }


    @Test
    public void test0001() throws Exception {
        driver.get("http://52.9.182.211:3001/v1/log-in");
        Thread.sleep(2000);
        driver.findElement(By.xpath(absoluteXpath)).sendKeys("1 ");
        driver.findElement(By.xpath(relativeXpath)).sendKeys("2 ");
        driver.findElement(By.xpath(singleAttribute)).sendKeys(("3 "));
        driver.findElement(By.xpath(multipleAttributes)).sendKeys("4 ");
        driver.findElement(By.xpath(usingAnd)).sendKeys("5 ");
        driver.findElement(By.xpath(usingOr)).sendKeys("6 ");
        driver.findElement(By.xpath(usingContains)).sendKeys("7 ");
        driver.findElement(By.xpath(usingStartsWith)).sendKeys("8 ");
        driver.findElement(By.xpath(usingLast)).sendKeys("9 ");
        driver.findElement(By.xpath(usingPosition)).sendKeys("10 ");
        driver.findElement(By.xpath(usingIndex)).sendKeys("11 ");
        driver.findElement(By.xpath(usingFollowing)).sendKeys("12 ");
        driver.findElement(By.xpath(usingPreceding)).sendKeys("13 ");
        boolean isDisplayed = driver.findElement(By.xpath(usingText)).isDisplayed();
        Assert.assertTrue(isDisplayed);
        driver.close();
    }


}
