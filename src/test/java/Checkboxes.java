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

import java.util.List;


public class Checkboxes {

    static String attributeValue;
    WebDriver driver;
    List<WebElement> listOfInputs;

    @BeforeSuite
    public void berofeSuite() {
        System.setProperty("webdriver.gecko.driver", "/Users/greatkate/IdeaProjects/TestNG/src/test/recources/driver/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void test0001() {

        openCheckBoxesPage();
        waitFor();
        getListOfCheckBoxes();

        assertByAttributeValue(0, null);
        assertByAttributeValue(1, "true");

        clickCheckBox(0);
        assertByAttributeValue(0, "true");

        uncheckAllCheckBoxes();
        assertAllAreUnchecked();


        checkAllCheckBoxes();
        assertAllChecked();

    }

    private void assertAllChecked() {
        for (WebElement element : listOfInputs) {
            String actual = element.getAttribute("checked");
            Assert.assertNotNull(actual);
        }
    }

    private void assertAllAreUnchecked() {
        for (WebElement element : listOfInputs) {
            String actual = element.getAttribute("checked");
            Assert.assertNull(actual);
        }
    }

    private void checkAllCheckBoxes() {
        for (WebElement element : listOfInputs)
            if (!element.isSelected()) {
                element.click();
            }
    }

    private void uncheckAllCheckBoxes() {
        for (WebElement element : listOfInputs) {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    private void clickCheckBox(int i) {
        listOfInputs.get(i).click();
    }

    private void getListOfCheckBoxes() {
        listOfInputs = driver.findElements(By.tagName("input"));
    }

    private void waitFor() {
        By resultsElement = By.tagName("input");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsElement));
    }

    private void assertByAttributeValue(int i, String expected) {
        WebElement element = listOfInputs.get(i);
        String actual = element.getAttribute("checked");
        Assert.assertEquals(actual, expected);
    }


    private void openCheckBoxesPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

    }

    @AfterMethod
    public void cleanckooki() {
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void afterSuite() {

        driver.close();
    }
}
