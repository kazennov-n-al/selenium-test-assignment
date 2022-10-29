package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CtcoVacanciesPage extends BaseCtcoPage {
    public CtcoVacanciesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(xpath = "//a[text() = 'TEST AUTOMATION ENGINEER']")
    public WebElement qaCareers;

    public void goToQaCareers() {
        wait.until(ExpectedConditions.elementToBeClickable(qaCareers));
        qaCareers.click();
    }
}
