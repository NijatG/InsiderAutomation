package data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class QualityAssurancePage extends BasePage {

    private By seeAllQAJobsButton = By.xpath("//*[@id=\"page-head\"]/div/div/div[1]/div/div/a");
    private By acceptAllCookiesButton = By.xpath("//*[@id=\"wt-cli-accept-all-btn\"]");
    private By locationDropdown = By.id("select2-filter-by-location-container");
    private By departmentDropdown = By.id("select2-filter-by-department-container");

    public QualityAssurancePage(WebDriver driver) {
        super(driver);
    }

    public void clickSeeAllQAJobs() {
        click(seeAllQAJobsButton);
        System.out.println("See All QA jobs is clicked");
    }

    public void acceptAllCookies() {
        click(acceptAllCookiesButton);
        System.out.println("Cookie is clicked");
    }

    public void selectLocation(String location) {
        click(locationDropdown);
        click(By.xpath(String.format("//li[contains(text(),'%s')]", location)));
        System.out.println(location + " is selected");
    }

    public void selectDepartment(String department) {
        click(departmentDropdown);
        click(By.xpath(String.format("//li[contains(text(),'%s')]", department)));
        System.out.println(department + " is selected");
    }

    public void scrollDownHalfPage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, window.innerHeight / 0.8);");
        System.out.println("Scrolled down half page");
    }
}
