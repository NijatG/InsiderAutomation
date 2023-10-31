package data;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public static   String chromeUrl = "/Users/nijatgulmammadov/Downloads/chromedriver-mac-arm64/chromedriver";

    public  static String websiteUrlGeneral = "https://useinsider.com/";

    public static  String getWebsiteUrlQA = "https://useinsider.com/careers/quality";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }



    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).click();
        } catch (WebDriverException e) {
            if (e.getMessage().contains("element click intercepted")) {
                WebElement element = driver.findElement(by);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } else throw e;  // Re-throw the exception if it's not an 'element click intercepted' exception
        }
    }
}