package data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {

    private By companyLink = By.partialLinkText("Company");
    private By careerLink = By.xpath("//*[@id=\"navbarNavDropdown\"]/ul[1]/li[6]/div/div[2]/a[2]");
    private By locationsHeader = By.xpath("//*[@id=\"career-our-location\"]/div/div/div/div[1]/h3");
    private By lifeAtInsiderHeader = By.xpath("/html/body/div[1]/section[4]/div/div/div/div[1]/div/h2");

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCompany() {
        click(companyLink);
        System.out.println("Company is clicked");
    }

    public void clickOnCareer() {
        click(careerLink);
        System.out.println("Career is clicked");
    }

    public void verifyLocationsIsVisible() {
        waitForVisibility(locationsHeader);
        System.out.println("Locations is visible");
    }

    public void verifyLifeAtInsiderIsVisible() {
        waitForVisibility(lifeAtInsiderHeader);
        System.out.println("Life at Insider is visible");
    }
}
