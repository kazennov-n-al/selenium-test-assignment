package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CtcoTestAutomationPositionPage extends BaseCtcoPage {

    @FindBy(xpath = "//p[.//*[contains(text(), 'Professional skills and qualification:')]]/following-sibling::ul[1]")
    WebElement qaSkillsList;

    public CtcoTestAutomationPositionPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.waitUntilLoaded();
    }

    public void countQaSkills() {
        wait.until(ExpectedConditions.elementToBeClickable(qaSkillsList));
        System.out.println(
                String.format("TEST AUTOMATION ENGINEER skills needed: %d",qaSkillsList.findElements(By.xpath("./li")).size()));
    }
}
