package pages;

import com.ibm.dtfj.phd.parser.Base;
import org.ctco.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public abstract class BaseCtcoPage {


    public By mainSection = By.xpath("//div[contains(@class, 'main-page')]");
    public By vacanciesInCareers = By.xpath("//a[text() ='Vacancies']");

    @FindBy(xpath = "//a[text() ='Careers']")
    public WebElement careersNavigation;

    protected WebDriver driver;

    protected WebDriverWait wait;

    public void waitUntilLoaded() {
        wait.until(
                d -> {
                    WebElement main = driver.findElement(mainSection);
                    if (main.getCssValue("background-image").endsWith(".gif")) {
                        return null;
                    } else {
                        return main;
                    }
                }
        );
    }

    public BaseCtcoPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        waitUntilLoaded();
    }

    public void goToVacanciesInCareers() {
        wait.until(ExpectedConditions.elementToBeClickable(careersNavigation));
        Actions actions = new Actions(driver);
        actions.moveToElement(careersNavigation).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(vacanciesInCareers));
        driver.findElement(vacanciesInCareers).click();
    }
}
