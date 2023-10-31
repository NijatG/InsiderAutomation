package data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobDetailsPage extends BasePage {

    private By viewRoleButton = By.xpath("//*[@id=\"jobs-list\"]/div[1]/div");
    public JobDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickViewRoleOnFirstJob() {
        click(viewRoleButton);
        System.out.println("Clicked Apply on the first job");
    }
}
