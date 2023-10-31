
import data.CareersPage;
import data.JobDetailsPage;
import data.QualityAssurancePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static data.BasePage.*;

public class Home {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", chromeUrl);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        CareersPage careersPage = new CareersPage(driver);
        QualityAssurancePage qaPage = new QualityAssurancePage(driver);
        JobDetailsPage jobDetailsPage = new JobDetailsPage(driver);

        try {
            // General Careers Page
            driver.get(websiteUrlGeneral);
            careersPage.clickOnCompany();
            careersPage.clickOnCareer();
            careersPage.verifyLocationsIsVisible();
            careersPage.verifyLifeAtInsiderIsVisible();

            // Quality Assurance Careers Page
            driver.get(getWebsiteUrlQA);
            qaPage.clickSeeAllQAJobs();
            qaPage.acceptAllCookies();
            qaPage.selectLocation("Istanbul, Turkey");
            qaPage.selectDepartment("Quality Assurance");
            qaPage.scrollDownHalfPage();

            // Job Details Page
            jobDetailsPage.clickViewRoleOnFirstJob();
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals("https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc/apply")) {
                System.out.println("Lever Application form page is displayed");
                System.out.println(currentUrl);
            } else {
                System.out.println("Lever Application form page is not displayed");
            }

            System.out.println("Test Completed Successfully");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
