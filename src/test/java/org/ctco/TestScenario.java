package org.ctco;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CtcoMainPage;
import pages.CtcoTestAutomationPositionPage;
import pages.CtcoVacanciesPage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class TestScenario {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        Path currentRelativePath = Paths.get("");
        String absolutePath = currentRelativePath.toAbsolutePath().toString();
        System.setProperty("webdriver.chrome.driver", absolutePath + "/src/main/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.logfile", absolutePath + "/log.log");

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterAll
    public static void cleanup() {
        driver.close();
    }

    @Test
    @DisplayName("Count QA skills")
    public void countQaSkills() {
        driver.get("https://ctco.lv/");

        CtcoMainPage mainPage = new CtcoMainPage(driver, wait);
        PageFactory.initElements(driver, mainPage);
        mainPage.goToVacanciesInCareers();

        CtcoVacanciesPage vacancies = new CtcoVacanciesPage(driver, wait);
        PageFactory.initElements(driver, vacancies);
        vacancies.goToQaCareers();

        CtcoTestAutomationPositionPage position = new CtcoTestAutomationPositionPage(driver, wait);
        PageFactory.initElements(driver, position);
        position.countQaSkills();
    }
}